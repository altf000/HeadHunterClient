package ru.hh.headhunterclient.data.repository.vacancy;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.data.api.MainService;
import ru.hh.headhunterclient.domain.entity.vacancies.keywords.KeywordsList;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12/9/17.
 * Облачное хранилище вакансий
 */

public class VacancyCloudStorage implements VacancyStore {

    private MainService mMainService;

    @Inject
    VacancyCloudStorage(MainService mMainService) {
        this.mMainService = mMainService;
    }

    public Observable<VacancyList> getVacancies(Map<String, String> params) {
        return mMainService.getVacancies(params);
    }

    @Override
    public Observable<VacancyDetail> getVacancyDetail(String id) {
        return mMainService.getVacancyDetail(id);
    }

    @Override
    public void saveVacancyList(VacancyList vacancyList, boolean clear) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public void saveVacancyDetail(VacancyDetail vacancyDetail) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public Observable<KeywordsList> getKeywords(String keywords) {
        return mMainService.getKeywords(keywords);
    }
}
