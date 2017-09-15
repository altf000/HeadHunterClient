package ru.hh.headhunterclient.data.repository.vacancy;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12.09.17.
 */

public interface VacancyStore {

    Observable<VacancyList> getVacancies(String query, int page);

    Observable<VacancyDetail> getVacancyDetail(String id);

    void saveVacancyList(VacancyList vacancyList, boolean clear);

    void saveVacancyDetail(VacancyDetail vacancyDetail);
}
