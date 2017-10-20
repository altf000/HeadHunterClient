package ru.hh.headhunterclient.ui.main;

import android.content.Context;
import android.content.Intent;
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

    private String mVacancyID;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, VacancyListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setCustomContentView(mCommonUtils.isLarge() ? R.layout.activity_base_tablet : R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.app_name));
        if (!mCommonUtils.isLarge() && savedInstanceState != null) {
            Fragment detailsFragment = getDetailsFragment();
            if (detailsFragment != null) {
                removeFragment(getDetailsFragment());
            }
        }
        VacancyListFragment listFragment = getListFragment();
        listFragment.setListener(id -> {
            mVacancyID = id;
            if (mCommonUtils.isLarge()) {
                changeDetailsFragment();
            } else {
                VacancyDetailActivity.startActivity(VacancyListActivity.this, id);
            }
        });
        changeFragment(listFragment, R.id.container);
        if (savedInstanceState != null && savedInstanceState.get(VACANCY_ID) != null) {
            mVacancyID = savedInstanceState.getString(VACANCY_ID);
        }
        if (mCommonUtils.isLarge()) {
            changeDetailsFragment();
        }
    }

    private VacancyListFragment getListFragment() {
        VacancyListFragment listFragment = (VacancyListFragment) getCurrentFragment(R.id.container);
        if (listFragment == null) {
            listFragment = VacancyListFragment.newInstance();
        }
        return listFragment;
    }

    private VacancyDetailFragment getDetailsFragment() {
        return (VacancyDetailFragment) getCurrentFragment(R.id.details_container);
    }

    private void changeDetailsFragment() {
        if (mVacancyID == null) {
            return;
        }
        VacancyDetailFragment vacancyDetailFragment = getDetailsFragment();
        if (vacancyDetailFragment == null) {
            vacancyDetailFragment = (VacancyDetailFragment) VacancyDetailFragment.newInstance(mVacancyID);
            changeFragment(vacancyDetailFragment, R.id.details_container);
        } else {
            vacancyDetailFragment.loadData(mVacancyID);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(VACANCY_ID, mVacancyID);
    }

    interface OnItemSelectedListener {
        void onItemSelected(String id);
    }
}
