package ru.hh.headhunterclient.domain.interactor.vacancies;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.search.VacancySearch;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12/9/17.
 */

public class VacancyListInteractor extends Interactor<VacancyList, VacancyListInteractor.Params> {

    private VacancyRepository mVacancyRepository;

    @Inject
    VacancyListInteractor(VacancyRepository vacancyRepository) {
        this.mVacancyRepository = vacancyRepository;
    }

    @Override
    protected Observable<VacancyList> createObservableInteractor(Params params) {
        return mVacancyRepository.getVacancies(params.searchParams);
    }

    public static final class Params {

        private final VacancySearch searchParams;

        private Params(VacancySearch searchParams) {
            this.searchParams = searchParams;
        }

        public static Params create(VacancySearch searchParams) {
            return new Params(searchParams);
        }
    }
}
