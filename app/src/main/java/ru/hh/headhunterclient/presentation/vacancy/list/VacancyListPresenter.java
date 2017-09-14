package ru.hh.headhunterclient.presentation.vacancy.list;

import ru.hh.headhunterclient.presentation.base.Presenter;

/**
 * Created by neox on 12/9/17.
 */

public abstract class VacancyListPresenter extends Presenter<VacancyListView> {

    public abstract void getVacancies();

    public abstract void getVacancies(String query);

    public abstract void getVacancies(String query, boolean loadMore);

    public abstract void setQuery(String query);

    public abstract void setPage(int page);

}
