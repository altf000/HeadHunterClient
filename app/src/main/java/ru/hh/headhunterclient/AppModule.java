package ru.hh.headhunterclient;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.data.DataModule;
import ru.hh.headhunterclient.data.api.NetworkModule;
import ru.hh.headhunterclient.ui.UiModule;

/**
 * Created by neox on 12/9/17.
 */

@Module(
        includes = {
                NetworkModule.class,
                DataModule.class,
                UiModule.class
        }
)
public class AppModule {

    private Application mApplication;

    AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

}
