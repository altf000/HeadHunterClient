package ru.hh.headhunterclient.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.ui.base.BaseActivity;
import ru.hh.headhunterclient.utils.CommonUtils;

/**
 * Created by neox on 12.09.17.
 * Экран детализации вакансии
 */

public class VacancyDetailActivity extends BaseActivity {

    public static final String EXTRA_ID = "extra_id";

    @Inject
    CommonUtils mCommonUtils;

    public static void startActivity(Context context, String id) {
        Intent intent = new Intent(context, VacancyDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(EXTRA_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);

        String id = getIntent().getStringExtra(EXTRA_ID);

        setCustomContentView(R.layout.activity_base);
        initToolbar(mToolbar);
        setTitle(getString(R.string.detailing));
        setBackEnabled();

        if (mCommonUtils.isLarge()) {
            finish();
            return;
        }

        Fragment fragment = getCurrentFragment(R.id.container);
        if (fragment == null) {
            fragment = VacancyDetailFragment.newInstance(id);
        }
        changeFragment(fragment, R.id.container);
    }
}
