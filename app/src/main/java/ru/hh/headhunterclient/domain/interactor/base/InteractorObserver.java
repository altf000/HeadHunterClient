package ru.hh.headhunterclient.domain.interactor.base;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by neox on 12/9/17.
 */

public class InteractorObserver<T> extends DisposableObserver<T> {

    @Override
    public void onComplete() {
    }

    @Override
    public void onError(Throwable e) {
    }

    @Override
    public void onNext(T t) {
    }
}