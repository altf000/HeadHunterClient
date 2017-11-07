package ru.hh.headhunterclient.di.module;

import android.app.Application;
import android.content.SharedPreferences;

import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.data.settings.VacancyFilter;
import ru.hh.headhunterclient.utils.CommonUtils;
import ru.hh.headhunterclient.utils.Constants;
import ru.hh.headhunterclient.utils.VacancyUtils;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by neox on 12/9/17.
 */

@Module(
        includes = {
                RepositoryModule.class
        }
)
public class DataModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application app) {
        return app.getSharedPreferences(Constants.KEY_PREFERENCES, MODE_PRIVATE);
    }

    @Provides
    @Singleton
    RxSharedPreferences provideRxSharedPreferences(SharedPreferences sharedPreferences) {
        return RxSharedPreferences.create(sharedPreferences);
    }

    @Provides
    @Singleton
    VacancyFilter provideVacancyFilter(RxSharedPreferences rxSharedPreferences) {
        return new VacancyFilter(rxSharedPreferences);
    }

    @Provides
    @Singleton
    CommonUtils provideCommonUtils(Application application) {
        return new CommonUtils(application);
    }

    @Provides
    @Singleton
    VacancyUtils provideVacancyUtils() {
        return new VacancyUtils();
    }
}
