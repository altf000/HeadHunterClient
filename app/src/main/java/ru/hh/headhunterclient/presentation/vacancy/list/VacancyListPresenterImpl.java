package ru.hh.headhunterclient.presentation.vacancy.list;

import javax.inject.Inject;

import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 12/9/17.
 */

public class VacancyListPresenterImpl extends VacancyListPresenter {

    private VacancyListInteractor mVacancyListInterceptor;
    private String mQuery;

    @Inject
    VacancyListPresenterImpl(VacancyListInteractor vacancyListInteractor) {
        this.mVacancyListInterceptor = vacancyListInteractor;
        this.mQuery = "";
    }

    @Override
    public void getVacancies() {
        getView().showLoading();
        getVacancies(mQuery);
    }

    @Override
    public void getVacancies(String query) {
        getView().showLoading();
        mQuery = query;
        mVacancyListInterceptor.setQuery(query);
        mVacancyListInterceptor.execute(new InteractorObserver<VacancyList>() {
            @Override
            public void onNext(VacancyList vacancyList) {
                getView().getVacanciesDone(vacancyList);
                getView().hideLoading();
                if (vacancyList.getFound() == 0 || vacancyList.getItems().isEmpty()) {
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
}
