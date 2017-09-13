package ru.hh.headhunterclient.presentation.base;

/**
 * Created by neox on 12/9/17.
 */

public abstract class Presenter<V extends MvpView> {

    private V mView;

    public void attachView(V view) {
        mView = view;
    }

    protected V getView() {
        return mView;
    }

    public void detachView() {
    }

}
