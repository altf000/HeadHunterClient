package ru.hh.headhunterclient.presentation.base;

import android.content.Context;

/**
 * Created by neox on 12/9/17.
 * Базовые методы view
 */
public interface MvpView {

    Context getContext();

    void showLoading();

    void hideLoading();

    void showError(String error);

}
