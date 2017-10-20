package ru.hh.headhunterclient.ui.splash;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.BindView;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.presentation.splash.SplashPresenter;
import ru.hh.headhunterclient.presentation.splash.SplashView;
import ru.hh.headhunterclient.ui.base.BaseActivity;
import ru.hh.headhunterclient.ui.main.VacancyListActivity;

/**
 * Created by neox on 21.09.17.
 * Сплеш экран
 */
public class SplashActivity extends BaseActivity implements SplashView {

    @BindView(R.id.mainContainer)
    View mContainer;

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCustomContentView(R.layout.activity_splash);
        initToolbar(mToolbar);
        hideToolbar();
        App.getAppComponent().inject(this);
        mSplashPresenter.attachView(this);
        mSplashPresenter.getDictionaries();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Snackbar.make(mContainer, error, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.try_again_snack_bar, view -> mSplashPresenter.getDictionaries())
                .show();
    }

    @Override
    public void startMainActivity() {
        VacancyListActivity.startActivity(getContext());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSplashPresenter.detachView();
    }
}
