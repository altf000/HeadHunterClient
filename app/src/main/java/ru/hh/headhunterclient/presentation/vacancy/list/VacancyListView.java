package ru.hh.headhunterclient.presentation.vacancy.list;

import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.presentation.base.MvpView;

/**
 * Created by neox on 12/9/17.
 */

public interface VacancyListView extends MvpView {

    void getVacanciesDone(VacancyList vacancyList, boolean loadMore);

    void showNoDataError();

}
