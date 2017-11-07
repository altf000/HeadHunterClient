package ru.hh.headhunterclient.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.di.component.AppComponent;

/**
 * Created by neox on 12/9/17.
 * Базовый фрагмент
 */
public abstract class BaseFragment extends Fragment {

    private Unbinder mUnBinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(App.getAppComponent());
        FirebaseAnalytics analytics = FirebaseAnalytics.getInstance(getContext());
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, getClass().getName());
        analytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        mUnBinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }

    public void setSubtitle(String text) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity.getSupportActionBar() != null) {
            baseActivity.getSupportActionBar().setSubtitle(text);
        }
    }

    public abstract void setupComponent(AppComponent upComponent);
}
