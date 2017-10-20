package ru.hh.headhunterclient.domain.interactor.vacancies;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 24.09.17.
 * Подскази для ключевых слов
 */
public class VacancyKeywordsInteractor extends Interactor<List<String>, VacancyKeywordsInteractor.Params> {

    private VacancyRepository mVacancyRepository;

    @Inject
    VacancyKeywordsInteractor(VacancyRepository vacancyRepository) {
        this.mVacancyRepository = vacancyRepository;
    }

    @Override
    protected Observable<List<String>> createObservableInteractor(Params params) {
        return mVacancyRepository.getKeywords(params.query);
    }

    public static final class Params {

        private final String query;

        private Params(String query) {
            this.query = query;
        }

        public static Params create(String query) {
            return new Params(query);
        }
    }

}
