package ru.hh.headhunterclient.domain.interactor.vacancies;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12.09.17.
 */

public class VacancyDetailInteractor extends Interactor<VacancyDetail, VacancyDetailInteractor.Params> {

    private VacancyRepository mVacancyRepository;

    @Inject
    VacancyDetailInteractor(VacancyRepository mVacancyRepository) {
        this.mVacancyRepository = mVacancyRepository;
    }

    @Override
    protected Observable<VacancyDetail> createObservableInteractor(Params params) {
        return mVacancyRepository.getVacancyDetail(params.vacancyID);
    }

    public static final class Params {

        private final String vacancyID;

        private Params(String vacancyID) {
            this.vacancyID = vacancyID;
        }

        public static Params create(String vacancyID) {
            return new Params(vacancyID);
        }
    }
}
