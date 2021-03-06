package ru.hh.headhunterclient.presentation.vacancy.detail;

import javax.inject.Inject;

import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyDetailInteractor;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyDetailInteractor.Params;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 12.09.17.
 * Презентер детализации вакансии
 */

public class DetailVacancyPresenterImpl extends DetailVacancyPresenter {

    private VacancyDetailInteractor mVacancyDetailInteractor;

    @Inject
    DetailVacancyPresenterImpl(VacancyDetailInteractor mVacancyDetailInteractor) {
        this.mVacancyDetailInteractor = mVacancyDetailInteractor;
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void getVacancyDetail(String id) {
        getView().showLoading();
        mVacancyDetailInteractor.execute(new VacancyDetailObserver(), Params.create(id));
    }

    @Override
    public void detachView() {
        if (mVacancyDetailInteractor != null) {
            mVacancyDetailInteractor.dispose();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoading();
        getView().showError(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    public final class VacancyDetailObserver extends InteractorObserver<VacancyDetail> {

        @Override
        public void onNext(VacancyDetail vacancyDetail) {
            getView().getDetailDone(vacancyDetail);
            getView().hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
