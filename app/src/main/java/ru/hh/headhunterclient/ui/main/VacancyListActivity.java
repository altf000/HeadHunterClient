package ru.hh.headhunterclient.ui.main;

import android.os.Bundle;

import javax.inject.Inject;

import ru.hh.headhunterclient.App;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.ui.base.BaseActivity;
import ru.hh.headhunterclient.ui.detail.VacancyDetailActivity;
import ru.hh.headhunterclient.ui.detail.VacancyDetailFragment;
import ru.hh.headhunterclient.utils.Utils;

/**
 * Created by neox on 12/9/17.
 * Главный экран приложения (список вакансий)
 */

public class VacancyListActivity extends BaseActivity {

    public static final String VACANCY_ID = "vacancy_id";

    @Inject
    Utils mUtils;

    private String mID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        setCustomContentView(mUtils.isLarge() ? R.layout.activity_base_tablet : R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.app_name));

        VacancyListFragment listFragment = (VacancyListFragment) getCurrentFragment(R.id.container);

        if (listFragment == null) {
            listFragment = VacancyListFragment.newInstance();
        }

        listFragment.setListener(id -> {
            mID = id;
            if (mUtils.isLarge()) {
                VacancyDetailFragment vacancyDetailFragment = (VacancyDetailFragment) getCurrentFragment(R.id.details_container);
                if (vacancyDetailFragment == null) {
                    vacancyDetailFragment = (VacancyDetailFragment) VacancyDetailFragment.newInstance(id);
                    changeFragment(vacancyDetailFragment, R.id.details_container);
                } else {
                    vacancyDetailFragment.loadData(mID);
                }
            } else {
                VacancyDetailActivity.startActivity(VacancyListActivity.this, id);
            }
        });

        changeFragment(listFragment, R.id.container);

        if (savedInstanceState != null && savedInstanceState.get(VACANCY_ID) != null) {
            mID = savedInstanceState.getString(VACANCY_ID);
        }

        if (mID != null && mUtils.isLarge()) {
            changeFragment(VacancyDetailFragment.newInstance(mID), R.id.details_container);
        }
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
