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
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.data.Keywords;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListPresenter;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListView;
import ru.hh.headhunterclient.ui.base.BaseFragment;
import ru.hh.headhunterclient.utils.Constants;
import ru.hh.headhunterclient.utils.LoadMoreListener;

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

    private LoadMoreListener mLoadMoreListener;
    private VacancyListActivity.OnItemSelectedListener mItemSelectedListener;
    private View mView;
    private VacancyListAdapter mAdapter;
    private int mAllItemsCount;

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
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mLoadMoreListener = new LoadMoreListener(linearLayoutManager);
        mLoadMoreListener.setOnLoadMoreListener(this::loadMore);
        mAdapter = new VacancyListAdapter(getContext(), mItemSelectedListener);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.addOnScrollListener(mLoadMoreListener);
        mRefreshLayout.setOnRefreshListener(this::refreshList);
        createSearchViewObservable();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mVacancyListPresenter.getVacancies(savedInstanceState != null);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mVacancyListPresenter.detachView();
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
    public void getVacanciesDone(VacancyList vacancyList, boolean loadMore) {
        setSubtitle(String.format(getString(R.string.vacancy_count), vacancyList.getFound()));
        mAllItemsCount = vacancyList.getFound();
        mAdapter.setList(vacancyList.getItems(), loadMore);
        mVacancyListPresenter.setPage(mAdapter.getItemCount() / vacancyList.getPerPage());
    }

    private void createSearchViewObservable() {
        RxTextView.textChanges(mQueryEditText)
                .debounce(Constants.EDIT_TEXT_CHANGES_DELAY, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .doOnNext(s -> mQuery.set(s))
                .skip(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::searchList);
    }

    private void loadMore() {
        if (mAllItemsCount > mAdapter.getItemCount()) {
            mVacancyListPresenter.loadMore();
        }
    }

    private void searchList(String query) {
        mLoadMoreListener.refresh();
        mVacancyListPresenter.getVacancies(query);
    }

    private void refreshList() {
        mLoadMoreListener.refresh();
        mVacancyListPresenter.getVacancies(false);
    }

    public void setListener(VacancyListActivity.OnItemSelectedListener listener) {
        this.mItemSelectedListener = listener;
    }
}
