package ru.hh.headhunterclient.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.ui.base.BaseActivity;
import ru.hh.headhunterclient.ui.detail.VacancyDetailActivity;
import ru.hh.headhunterclient.ui.detail.VacancyDetailFragment;
import ru.hh.headhunterclient.utils.CommonUtils;

/**
 * Created by neox on 12/9/17.
 * Главный экран приложения (список вакансий)
 */

public class VacancyListActivity extends BaseActivity {

    public static final String VACANCY_ID = "vacancy_id";

    @Inject
    CommonUtils mCommonUtils;

    private String mID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setCustomContentView(mCommonUtils.isLarge() ? R.layout.activity_base_tablet : R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.app_name));
        if (!mCommonUtils.isLarge()) {
            removeDetailsFragment();
        }
        VacancyListFragment listFragment = (VacancyListFragment) getCurrentFragment(R.id.container);
        if (listFragment == null) {
            listFragment = VacancyListFragment.newInstance();
        }
        listFragment.setListener(id -> {
            mID = id;
            if (mCommonUtils.isLarge()) {
                changeDetailsFragment();
            } else {
                VacancyDetailActivity.startActivity(VacancyListActivity.this, id);
            }
        });
        changeFragment(listFragment, R.id.container);
        if (savedInstanceState != null && savedInstanceState.get(VACANCY_ID) != null) {
            mID = savedInstanceState.getString(VACANCY_ID);
        }
        if (mCommonUtils.isLarge()) {
            changeDetailsFragment();
        }
    }

    private void removeDetailsFragment() {
        Fragment detailsFragment = getDetailsFragment();
        if (detailsFragment != null) {
            removeFragment(getDetailsFragment());
        }
    }

    private void changeDetailsFragment() {
        if (mID == null) {
            return;
        }
        VacancyDetailFragment vacancyDetailFragment = getDetailsFragment();
        if (vacancyDetailFragment == null) {
            vacancyDetailFragment = (VacancyDetailFragment) VacancyDetailFragment.newInstance(mID);
            changeFragment(vacancyDetailFragment, R.id.details_container);
        } else {
            vacancyDetailFragment.loadData(mID);
        }
    }

    private VacancyDetailFragment getDetailsFragment() {
        return (VacancyDetailFragment) getCurrentFragment(R.id.details_container);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(VACANCY_ID, mID);
    }

    public interface OnItemSelectedListener {
        void onItemSelected(String id);
    }
}
