package ru.hh.headhunterclient.di.module;

import android.app.Application;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.hh.headhunterclient.data.api.MainService;
import ru.hh.headhunterclient.di.qualifier.Logger;
import timber.log.Timber;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Created by neox on 12/9/17.
 */

@Module
public class NetworkModule {

    private static final int TIMEOUT = 60;
    private static final String BASE_URL = "https://api.hh.ru/";

    @Provides
    @Singleton
    MainService providesMainService(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(MainService.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideMainHttpClient(Application application, @Logger Interceptor interceptor) {
        File cacheFile = null;
        Cache cache = null;
        try {
            cacheFile = new File(application.getCacheDir(), "responses");
            cache = new Cache(cacheFile, 10 * 1024 * 1024);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, SECONDS)
                .readTimeout(TIMEOUT, SECONDS)
                .writeTimeout(TIMEOUT, SECONDS)
                .addInterceptor(interceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    @Logger
    Interceptor provideLoggerInterceptor() {
        return new HttpLoggingInterceptor(message -> Timber.d(message))
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
