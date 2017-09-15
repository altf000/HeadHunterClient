package ru.hh.headhunterclient.data;

import android.app.Application;
import android.content.SharedPreferences;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.data.repository.RepositoryModule;
import ru.hh.headhunterclient.utils.CommonUtils;
import ru.hh.headhunterclient.utils.Constants;

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
    @Keywords
    Preference<String> provideQuickPayListPreference(RxSharedPreferences preferences) {
        return preferences.getString(Constants.KEY_KEYWORDS);
    }

    @Provides
    @Singleton
    CommonUtils provideUtils(Application application) {
        return new CommonUtils(application);
    }
}
