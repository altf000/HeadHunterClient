package ru.hh.headhunterclient.ui.detail;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.presentation.vacancy.detail.DetailVacancyPresenter;
import ru.hh.headhunterclient.presentation.vacancy.detail.DetailVacancyPresenterImpl;

/**
 * Created by neox on 12.09.17.
 */

@Module
public class VacancyDetailsModule {

    @Provides
    DetailVacancyPresenter provideDetailVacancyPresenter(DetailVacancyPresenterImpl detailVacancyPresenter) {
        return detailVacancyPresenter;
    }

}
