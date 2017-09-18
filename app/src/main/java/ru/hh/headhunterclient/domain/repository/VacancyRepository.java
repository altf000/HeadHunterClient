package ru.hh.headhunterclient.domain.repository;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.search.VacancySearch;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12/9/17.
 * Репозиторий вакансий
 */
public interface VacancyRepository {

    /**
     * Получение списка вакансий
     *
     * @param vacancySearch параметры поиска
     * @return список вакансий
     */
    Observable<VacancyList> getVacancies(VacancySearch vacancySearch);

    /**
     * Получение детализации вакансии
     *
     * @param id идентификатор вакансии
     * @return полное описание вакансии
     */
    Observable<VacancyDetail> getVacancyDetail(String id);
}
