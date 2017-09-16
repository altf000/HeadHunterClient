package ru.hh.headhunterclient.domain.repository;

import io.reactivex.Observable;
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
     * @param query    ключевые слова
     * @param page     номер страницы
     * @param cached   получать закешированные данные или нет
     * @param loadMore используется ли "Загрузить еще"
     * @return список вакансий
     */
    Observable<VacancyList> getVacancies(String query, int page, boolean cached, boolean loadMore);

    /**
     * Получение детализации вакансии
     *
     * @param id идентификатор вакансии
     * @return полное описание вакансии
     */
    Observable<VacancyDetail> getVacancyDetail(String id);
}
