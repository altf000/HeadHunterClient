package ru.hh.headhunterclient.ui.main;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListPresenter;
import ru.hh.headhunterclient.presentation.vacancy.list.VacancyListPresenterImpl;

/**
 * Created by neox on 12/9/17.
 */

@Module
public class VacancyListModule {

    @Provides
    VacancyListPresenter provideVacancyListPresenter(VacancyListPresenterImpl vacancyListPresenter) {
        return vacancyListPresenter;
    }

}
