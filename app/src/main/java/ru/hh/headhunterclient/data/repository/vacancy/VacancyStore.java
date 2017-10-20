package ru.hh.headhunterclient.data.repository.vacancy;

import java.util.Map;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.keywords.KeywordsList;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12.09.17.
 */

public interface VacancyStore {

    Observable<VacancyList> getVacancies(Map<String, String> params);

    Observable<VacancyDetail> getVacancyDetail(String id);

    void saveVacancyList(VacancyList vacancyList, boolean clear);

    void saveVacancyDetail(VacancyDetail vacancyDetail);

    Observable<KeywordsList> getKeywords(String keywords);
}
