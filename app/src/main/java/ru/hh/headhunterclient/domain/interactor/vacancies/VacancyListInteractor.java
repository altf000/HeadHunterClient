package ru.hh.headhunterclient.domain.interactor.vacancies;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.data.settings.VacancyFilter;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12/9/17.
 * Список вакансий
 */
public class VacancyListInteractor extends Interactor<VacancyList, VacancyListInteractor.Params> {

    private VacancyRepository mVacancyRepository;

    @Inject
    VacancyListInteractor(VacancyRepository vacancyRepository) {
        this.mVacancyRepository = vacancyRepository;
    }

    @Override
    protected Observable<VacancyList> createObservableInteractor(Params params) {
        return mVacancyRepository.getVacancies(params.vacancyFilter);
    }

    public static final class Params {

        private final VacancyFilter vacancyFilter;

        private Params(VacancyFilter vacancyFilter) {
            this.vacancyFilter = vacancyFilter;
        }

        public static Params create(VacancyFilter vacancyFilter) {
            return new Params(vacancyFilter);
        }
    }
}
