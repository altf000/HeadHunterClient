package ru.hh.headhunterclient.presentation.vacancy.detail;

import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.presentation.base.MvpView;

/**
 * Created by neox on 12.09.17.
 */

public interface DetailVacancyView extends MvpView {

    void getDetailDone(VacancyDetail vacancyDetail);

}
