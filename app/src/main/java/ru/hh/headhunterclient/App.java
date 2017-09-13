package ru.hh.headhunterclient;

import android.app.Application;

import io.realm.Realm;
import timber.log.Timber;

/**
 * Created by neox on 12/9/17.
 */

public class App extends Application {

    private static AppComponent component;

    public static AppComponent getAppComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Realm.init(this);
    }
}
