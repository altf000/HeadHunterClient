package ru.hh.headhunterclient.presentation.vacancy.search;

import ru.hh.headhunterclient.presentation.base.Presenter;

/**
 * Created by neox on 23.09.17.
 */

public abstract class VacancySearchPresenter extends Presenter<VacancySearchView> {

    public abstract void getAreas(String query);

}
