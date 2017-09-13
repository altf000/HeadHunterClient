package ru.hh.headhunterclient.presentation.vacancy.detail;

import ru.hh.headhunterclient.presentation.base.Presenter;

/**
 * Created by neox on 12.09.17.
 */

public abstract class DetailVacancyPresenter extends Presenter<DetailVacancyView> {

    public abstract void getVacancyDetail(String id);

}
