package ru.hh.headhunterclient.ui.search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.data.pref.VacancyFilter;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.presentation.vacancy.search.VacancySearchPresenter;
import ru.hh.headhunterclient.presentation.vacancy.search.VacancySerachView;
import ru.hh.headhunterclient.ui.base.BaseDialogFragment;
import ru.hh.headhunterclient.utils.CommonUtils;
import ru.hh.headhunterclient.utils.Constants;

/**
 * Created by neox on 21.09.17.
 * BottomSheet fragment для поиска вакансий
 */
public class VacancySearchFragment extends BaseDialogFragment implements VacancySerachView {

    @BindView(R.id.vacancyArea)
    AutoCompleteTextView mVacancyArea;

    @BindView(R.id.vacancySalary)
    EditText mVacancySalary;

    @BindView(R.id.salarySpinner)
    Spinner mSalarySpinner;

    @BindView(R.id.searchVacancyButton)
    Button mSearchButton;

    @Inject
    VacancyFilter mVacancyFilter;

    @Inject
    VacancySearchPresenter mVacancySearchPresenter;

    @Inject
    CommonUtils mCommonUtils;

    private List<String> mAreaData;
    private List<String> mSalaryValues;
    private List<String> mSalaryKeys;

    private String mSelectedAreaName;
    private OnSearchListener mSearchListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        mVacancySearchPresenter.attachView(this);
        mAreaData = new ArrayList<>();
        mSalaryKeys = Arrays.asList(getResources().getStringArray(R.array.salary_keys));
        mSalaryValues = Arrays.asList(getResources().getStringArray(R.array.salary_values));
        mSelectedAreaName = mVacancyFilter.getAreaName();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_vacancy, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mVacancySearchPresenter.detachView();
    }

    private void initViews() {

        mVacancyArea.setText(mVacancyFilter.getAreaName());
        mVacancySalary.setText(mVacancyFilter.getSalary());

        RxTextView.textChanges(mVacancyArea)
                .debounce(Constants.EDIT_TEXT_CHANGES_DELAY, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mVacancySearchPresenter.getAreas(s));

        RxTextView.textChanges(mVacancySalary)
                .map(CharSequence::toString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mVacancyFilter.setSalary(s));

        mSalarySpinner.setAdapter(new ArrayAdapter<>(getContext(), R.layout.item_spinner, mSalaryValues));
        mSalarySpinner.setSelection(getSavedCurrencyPosition());
        mSalarySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mVacancyFilter.setCurrency(mSalaryKeys.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        RxView.clicks(mSearchButton).subscribe(o -> {
            if (mSearchListener != null) {
                mSearchListener.search();
                dismiss();
            }
        });
    }

    @Override
    public void showLoading() {
        // nothing
    }

    @Override
    public void hideLoading() {
        // nothing
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void getAreasDone(List<Area> areaList) {
        mAreaData = Stream.of(areaList).map(Area::getName).collect(Collectors.toList());
        mVacancyArea.setAdapter(new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, mAreaData));
        mVacancyArea.setOnItemClickListener((adapterView, view, i, l) -> {
            mSelectedAreaName = areaList.get(i).getName();
            mVacancyFilter.setAreaName(mSelectedAreaName);
            mVacancyFilter.setAreaID(areaList.get(i).getId());
        });
        if (mSelectedAreaName == null) {
            mVacancyArea.showDropDown();
        } else if (!mSelectedAreaName.equals(mVacancyArea.getText().toString())) {
            mVacancyArea.showDropDown();
        }
    }

    public void setSearchListener(OnSearchListener searchListener) {
        this.mSearchListener = searchListener;
    }

    private int getSavedCurrencyPosition() {
        for (int i = 0; i < mSalaryKeys.size(); i++) {
            if (mVacancyFilter.getCurrency().equals(mSalaryKeys.get(i))) {
                return i;
            }
        }
        return 0;
    }

    public interface OnSearchListener {
        void search();
    }
}
