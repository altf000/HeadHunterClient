package ru.hh.headhunterclient.presentation.vacancy.list;

import javax.inject.Inject;

import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 12/9/17.
 * Презентер списка вакансий
 */

public class VacancyListPresenterImpl extends VacancyListPresenter {

    private VacancyListInteractor mVacancyListInterceptor;
    private String mQuery;
    private int mCurrentPage;
    private boolean mCached;
    private boolean mLoadMore;

    @Inject
    VacancyListPresenterImpl(VacancyListInteractor vacancyListInteractor) {
        this.mVacancyListInterceptor = vacancyListInteractor;
        this.mQuery = "";
    }

    @Override
    public void getVacancies(boolean cached) {
        this.mCached = cached;
        this.mCurrentPage = 0;
        this.mLoadMore = false;
        getVacanciesList();
    }

    @Override
    public void getVacancies(String query) {
        this.mQuery = query;
        this.mCurrentPage = 0;
        this.mCached = false;
        this.mLoadMore = false;
        getVacanciesList();
    }

    @Override
    public void loadMore() {
        this.mLoadMore = true;
        this.mCached = false;
        getVacanciesList();
    }

    private void getVacanciesList() {
        getView().showLoading();
        mVacancyListInterceptor.setQuery(mQuery);
        mVacancyListInterceptor.setPage(mCurrentPage);
        mVacancyListInterceptor.setCached(mCached);
        mVacancyListInterceptor.setLoadMore(mLoadMore);
        mVacancyListInterceptor.execute(new InteractorObserver<VacancyList>() {
            @Override
            public void onNext(VacancyList vacancyList) {
                getView().getVacanciesDone(vacancyList, mLoadMore);
                getView().hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                showErrorMessage(e);
            }
        });
    }

    @Override
    public void detachView() {
        if (mVacancyListInterceptor != null) {
            mVacancyListInterceptor.dispose();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoading();
        getView().showError(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    public void setQuery(String query) {
        this.mQuery = query;
    }

    @Override
    public void setPage(int page) {
        this.mCurrentPage = page;
    }
}
