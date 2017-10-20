package ru.hh.headhunterclient.ui.search;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.presentation.vacancy.search.VacancySearchPresenter;
import ru.hh.headhunterclient.presentation.vacancy.search.VacancySearchPresenterImpl;

/**
 * Created by neox on 23.09.17.
 */

@Module
public class VacancySearchModule {

    @Provides
    VacancySearchPresenter provideVacancySearchPresenter(VacancySearchPresenterImpl vacancySearchPresenter) {
        return vacancySearchPresenter;
    }

}
