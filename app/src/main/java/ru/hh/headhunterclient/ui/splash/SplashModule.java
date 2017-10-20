package ru.hh.headhunterclient.ui.splash;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.presentation.splash.SplashPresenter;
import ru.hh.headhunterclient.presentation.splash.SplashPresenterImpl;

/**
 * Created by neox on 21.09.17.
 */

@Module
public class SplashModule {

    @Provides
    SplashPresenter provideSplashPresenter(SplashPresenterImpl splashPresenter) {
        return splashPresenter;
    }

}
