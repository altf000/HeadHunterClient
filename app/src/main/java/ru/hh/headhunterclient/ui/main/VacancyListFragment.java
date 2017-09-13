package ru.hh.headhunterclient.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.f2prateek.rx.preferences2.Preference;
import com.jakewharton.rxbinding2.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.App;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.data.Keywords;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListPresenter;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListView;
import ru.hh.headhunterclient.ui.base.BaseFragment;
import ru.hh.headhunterclient.utils.Constants;

/**
 * Created by neox on 12/9/17.
 * Фрагмент списка вакансий
 */

public class VacancyListFragment extends BaseFragment implements VacancyListView {

    @BindView(R.id.mainLayout)
    View mMainLayout;

    @BindView(R.id.vacancyEditText)
    EditText mQueryEditText;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mRefreshLayout;

    @BindView(R.id.noDataError)
    TextView mNoDataError;

    @Inject
    VacancyListPresenter mVacancyListPresenter;

    @Inject
    @Keywords
    Preference<String> mQuery;

    private VacancyListActivity.OnItemSelectedListener mItemListener;
    private View mView;
    private VacancyListAdapter mAdapter;

    public static VacancyListFragment newInstance() {
        return new VacancyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        mVacancyListPresenter.attachView(this);
        mVacancyListPresenter.setQuery(mQuery.get());
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
        mQueryEditText.setText(mQuery.get());
        mAdapter = new VacancyListAdapter(getContext(), mItemListener);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mRefreshLayout.setOnRefreshListener(() -> mVacancyListPresenter.getVacancies());
        createSearchViewObservable();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mVacancyListPresenter.getVacancies();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mVacancyListPresenter.detachView();
    }

    @Override
    public void showLoading() {
        mRecyclerView.setVisibility(View.GONE);
        mNoDataError.setVisibility(View.GONE);
        mRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        mRecyclerView.setVisibility(View.VISIBLE);
        mRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG)
                .setAction(R.string.try_again_snack_bar, v -> mVacancyListPresenter.getVacancies())
                .show();
    }

    @Override
    public void showNoDataError() {
        mNoDataError.setVisibility(View.VISIBLE);
    }

    @Override
    public void getVacanciesDone(VacancyList vacancyList) {
        mAdapter.setList(vacancyList.getItems());
    }

    private void createSearchViewObservable() {
        RxTextView.textChanges(mQueryEditText)
                .debounce(Constants.EDIT_TEXT_CHANGES_DELAY, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .skip(1)
                .doOnNext(s -> mQuery.set(s))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> mVacancyListPresenter.getVacancies(s));
    }

    public void setListener(VacancyListActivity.OnItemSelectedListener listener) {
        this.mItemListener = listener;
    }
}
