package ru.hh.headhunterclient.presentation.base;

/**
 * Created by neox on 12/9/17.
 * Базовый presenter
 */
public abstract class Presenter<V extends MvpView> {

    private V mView;

    public void attachView(V view) {
        mView = view;
        onViewAttached();
    }

    protected V getView() {
        return mView;
    }

    public void detachView() {
    }

    public abstract void onViewAttached();

}
