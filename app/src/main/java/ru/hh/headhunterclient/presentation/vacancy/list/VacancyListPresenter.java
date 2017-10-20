package ru.hh.headhunterclient.presentation.vacancy.list;

import ru.hh.headhunterclient.presentation.base.Presenter;

/**
 * Created by neox on 12/9/17.
 */

public abstract class VacancyListPresenter extends Presenter<VacancyListView> {

    /**
     * Получение списка вакансий (используется при первом открытии экрана или при перевороте)
     *
     * @param cached подтягивать данные из сети или из бд
     */
    public abstract void getVacancies(boolean cached);

    /**
     * Получение списка вакансий (используется для поиска)
     *
     * @param query ключевые слова
     */
    public abstract void searchVacancies(String query);

    /**
     * Получение списка вакансий (используется для подгрузки вакансий порциями при скроллинге)
     */
    public abstract void loadMore();

    /**
     * Получение подсказок для ключевых слов
     *
     * @param text текст
     */
    public abstract void getKeywords(String text);
}
