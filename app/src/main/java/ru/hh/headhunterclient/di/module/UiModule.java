package ru.hh.headhunterclient.di.module;

import dagger.Module;
import ru.hh.headhunterclient.ui.detail.VacancyDetailsModule;
import ru.hh.headhunterclient.ui.main.VacancyListModule;
import ru.hh.headhunterclient.ui.search.VacancySearchModule;
import ru.hh.headhunterclient.ui.splash.SplashModule;

/**
 * Created by neox on 11.09.17.
 */

@Module(
        includes = {
                SplashModule.class,
                VacancyListModule.class,
                VacancyDetailsModule.class,
                VacancySearchModule.class
        }
)
public class UiModule {
}
