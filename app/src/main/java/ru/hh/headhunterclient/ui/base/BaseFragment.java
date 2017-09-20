package ru.hh.headhunterclient.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by neox on 12/9/17.
 */

public class BaseFragment extends Fragment {

    private Unbinder mUnBinder;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        mUnBinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnBinder.unbind();
    }

    public void setSubtitle(String text) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity.getSupportActionBar() != null) {
            baseActivity.getSupportActionBar().setSubtitle(text);
        }
    }
}
