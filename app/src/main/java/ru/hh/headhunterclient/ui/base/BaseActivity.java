package ru.hh.headhunterclient.ui.base;

import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.hh.headhunterclient.R;

/**
 * Created by neox on 12/9/17.
 */

public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    private Unbinder mUnBinder;

    protected void setCustomContentView(@LayoutRes int resId) {
        ViewGroup container = (ViewGroup) findViewById(android.R.id.content);
        getLayoutInflater().inflate(resId, container);
        mUnBinder = ButterKnife.bind(this, container);
    }

    public void initToolbar(Toolbar toolbar) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            final ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.setHomeButtonEnabled(false);
                supportActionBar.setDisplayHomeAsUpEnabled(false);
            }
        }
    }

    public void hideToolbar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    public void setBackEnabled() {
        final ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void changeFragment(Fragment fragment, @IdRes int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .commitNow();
    }

    public void removeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .remove(fragment)
                .commitNow();
    }

    public void changeFragmentBackStack(Fragment fragment, @IdRes int containerId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, fragment)
                .addToBackStack("null")
                .commitNow();
    }

    public Fragment getCurrentFragment() {
        return getSupportFragmentManager()
                .findFragmentById(R.id.container);
    }

    public Fragment getCurrentFragment(int id) {
        return getSupportFragmentManager()
                .findFragmentById(id);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnBinder.unbind();
    }
}
