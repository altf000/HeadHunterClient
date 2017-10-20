package ru.hh.headhunterclient.di.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

}
