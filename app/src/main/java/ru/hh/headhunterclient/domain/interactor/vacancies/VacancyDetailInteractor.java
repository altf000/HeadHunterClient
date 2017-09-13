package ru.hh.headhunterclient.domain.interactor.vacancies;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12.09.17.
 */

public class VacancyDetailInteractor extends Interactor<VacancyDetail> {

    private VacancyRepository mVacancyRepository;
    private String mID;

    @Inject
    public VacancyDetailInteractor(VacancyRepository mVacancyRepository) {
        this.mVacancyRepository = mVacancyRepository;
    }

    @Override
    protected Observable<VacancyDetail> createObservableInteractor() {
        return mVacancyRepository.getVacancyDetail(mID);
    }

    public void setID(String mID) {
        this.mID = mID;
    }
}
