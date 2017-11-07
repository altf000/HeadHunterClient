package ru.hh.headhunterclient.ui.main;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.data.settings.VacancyFilter;
import ru.hh.headhunterclient.di.component.AppComponent;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListPresenter;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListView;
import ru.hh.headhunterclient.ui.base.BaseFragment;
import ru.hh.headhunterclient.ui.search.VacancySearchFragment;
import ru.hh.headhunterclient.utils.Constants;
import ru.hh.headhunterclient.utils.RecyclerViewListener;

/**
 * Created by neox on 12/9/17.
 * Фрагмент списка вакансий
 */
public class VacancyListFragment extends BaseFragment implements VacancyListView {

    private final String KEY_RECYCLER_STATE = "recycler_state";

    @BindView(R.id.mainLayout)
    View mMainLayout;

    @BindView(R.id.vacancyEditText)
    AutoCompleteTextView mQueryEditText;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.noDataError)
    TextView mNoDataError;

    @BindView(R.id.fab)
    FloatingActionButton mFab;

    @Inject
    VacancyFilter mVacancyFilter;

    @Inject
    VacancyListPresenter mVacancyListPresenter;

    private View mView;
    private RecyclerViewListener mRecyclerViewListener;
    private VacancyListActivity.OnItemSelectedListener mItemSelectedListener;
    private VacancyListAdapter mAdapter;
    private Parcelable mRecyclerViewState;
    private String mSelectedKeyword;

    public static VacancyListFragment newInstance() {
        return new VacancyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            mRecyclerViewState = savedInstanceState.getParcelable(KEY_RECYCLER_STATE);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mVacancyListPresenter.attachView(this);
        mVacancyListPresenter.getVacancies(savedInstanceState != null);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mVacancyListPresenter.detachView();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_RECYCLER_STATE, mRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    @Override
    public void showLoading() {
        mRefreshLayout.setRefreshing(true);
        mNoDataError.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        mRefreshLayout.setRefreshing(false);
        mNoDataError.setVisibility(mAdapter.getItemCount() == 0 ? View.VISIBLE : View.GONE);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void getVacanciesDone(List<Vacancy> vacancyList) {
        mAdapter.setList(vacancyList);
        restoreState();
    }

    @Override
    public void setSubtitle(String subtitle) {
        super.setSubtitle(subtitle);
    }

    @Override
    public void setupComponent(AppComponent upComponent) {
        App.getAppComponent().inject(this);
    }

    @Override
    public void setQuery(String query) {
        mQueryEditText.setText(query);
    }

    @Override
    public void getKeywordsDone(List<String> keywords) {
        mQueryEditText.setAdapter(new ArrayAdapter<>(getContext(), R.layout.support_simple_spinner_dropdown_item, keywords));
        mQueryEditText.setOnItemClickListener((adapterView, view, i, l) -> {
            mSelectedKeyword = keywords.get(i);
            searchList(keywords.get(i));
        });
        if (mSelectedKeyword == null || !mSelectedKeyword.equals(mQueryEditText.getText().toString())) {
            mQueryEditText.showDropDown();
        }
    }

    private void restoreState() {
        if (mRecyclerViewState != null) {
            mRecyclerView.getLayoutManager().onRestoreInstanceState(mRecyclerViewState);
            mRecyclerViewState = null;
        }
    }

    private void initViews() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerViewListener = new RecyclerViewListener(linearLayoutManager);
        mRecyclerViewListener.setOnLoadMoreListener(() -> mVacancyListPresenter.loadMore());
        mRecyclerViewListener.setChangeFabListener(hide -> {
            if (hide) {
                mFab.hide();
            } else {
                mFab.show();
            }
        });
        mAdapter = new VacancyListAdapter(getContext(), mItemSelectedListener);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mRecyclerViewListener);
        mRefreshLayout.setOnRefreshListener(this::refreshList);
        RxView.clicks(mFab).subscribe(o -> {
            VacancySearchFragment fragment = new VacancySearchFragment();
            fragment.setSearchListener(() -> mVacancyListPresenter.getVacancies(false));
            fragment.show(getActivity().getSupportFragmentManager(), fragment.getTag());
        });
        createSearchViewObservable();
    }

    private void createSearchViewObservable() {
        RxTextView.textChanges(mQueryEditText)
                .debounce(Constants.EDIT_TEXT_CHANGES_DELAY, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .filter(s -> !s.isEmpty())
                .skip(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mVacancyListPresenter.getKeywords(s));
    }

    private void searchList(String query) {
        mRecyclerViewListener.refresh();
        mVacancyListPresenter.searchVacancies(query);
    }

    private void refreshList() {
        mRecyclerViewListener.refresh();
        mVacancyListPresenter.getVacancies(false);
    }

    public void setListener(VacancyListActivity.OnItemSelectedListener listener) {
        this.mItemSelectedListener = listener;
    }
}
