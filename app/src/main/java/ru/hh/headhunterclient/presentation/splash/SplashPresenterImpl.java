package ru.hh.headhunterclient.presentation.splash;

import javax.inject.Inject;

import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.splash.SplashInteractor;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 21.09.17.
 * Презентер сплеш экрана
 */

public class SplashPresenterImpl extends SplashPresenter {

    private SplashInteractor mSplashInteractor;

    @Inject
    SplashPresenterImpl(SplashInteractor splashInteractor) {
        this.mSplashInteractor = splashInteractor;
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void getDictionaries() {
        getView().showLoading();
        mSplashInteractor.execute(new SplashObserver(), null);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSplashInteractor != null) {
            mSplashInteractor.dispose();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoading();
        getView().showError(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    public final class SplashObserver extends InteractorObserver<Boolean> {

        @Override
        public void onNext(Boolean bool) {
            getView().startMainActivity();
            getView().hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
