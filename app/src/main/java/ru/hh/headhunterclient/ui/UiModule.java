package ru.hh.headhunterclient.ui;

import dagger.Module;
import ru.hh.headhunterclient.ui.detail.VacancyDetailsModule;
import ru.hh.headhunterclient.ui.main.VacancyListModule;

/**
 * Created by neox on 11.09.17.
 */

@Module(
        includes = {
                VacancyListModule.class,
                VacancyDetailsModule.class
        }
)
public class UiModule {
}
