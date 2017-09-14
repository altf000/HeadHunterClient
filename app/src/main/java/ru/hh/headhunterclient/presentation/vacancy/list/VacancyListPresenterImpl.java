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

    @Inject
    VacancyListPresenterImpl(VacancyListInteractor vacancyListInteractor) {
        this.mVacancyListInterceptor = vacancyListInteractor;
        this.mQuery = "";
    }

    @Override
    public void getVacancies() {
        getVacancies(mQuery, false);
    }

    @Override
    public void getVacancies(String query) {
        this.mQuery = query;
        this.mCurrentPage = 0;
        getVacancies(mQuery, false);
    }

    @Override
    public void getVacancies(String query, boolean loadMore) {
        getView().showLoading();
        if (!loadMore) {
            mCurrentPage = 0;
        }
        mQuery = query;
        mVacancyListInterceptor.setQuery(mQuery);
        mVacancyListInterceptor.setPage(mCurrentPage);
        mVacancyListInterceptor.execute(new InteractorObserver<VacancyList>() {
            @Override
            public void onNext(VacancyList vacancyList) {
                getView().getVacanciesDone(vacancyList, loadMore);
                getView().hideLoading();
                if (vacancyList.getItems().isEmpty() && !loadMore) {
                    getView().showNoDataError();
                }
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
