package ru.hh.headhunterclient.domain.repository;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12/9/17.
 */

public interface VacancyRepository {

    Observable<VacancyList> getVacancies(String query, int page);

    Observable<VacancyDetail> getVacancyDetail(String id);
}
