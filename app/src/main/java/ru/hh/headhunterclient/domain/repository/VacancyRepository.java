package ru.hh.headhunterclient.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.hh.headhunterclient.data.pref.VacancyFilter;
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
     * @param vacancyFilter параметры поиска
     * @return список вакансий
     */
    Observable<VacancyList> getVacancies(VacancyFilter vacancyFilter);

    /**
     * Получение детализации вакансии
     *
     * @param id идентификатор вакансии
     * @return полное описание вакансии
     */
    Observable<VacancyDetail> getVacancyDetail(String id);

    /**
     * Подсказки для поиска вакансий по ключевым словам
     *
     * @param keywords ключевое слово
     * @return подсказки
     */
    Observable<List<String>> getKeywords(String keywords);
}
