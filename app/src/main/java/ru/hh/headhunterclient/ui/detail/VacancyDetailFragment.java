package ru.hh.headhunterclient.ui.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import ru.hh.headhunterclient.app.App;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.presentation.vacancy.detail.DetailVacancyPresenter;
import ru.hh.headhunterclient.presentation.vacancy.detail.DetailVacancyView;
import ru.hh.headhunterclient.ui.base.BaseFragment;

/**
 * Created by neox on 12.09.17.
 * Фрагмент детализации вакансии
 */

public class VacancyDetailFragment extends BaseFragment implements DetailVacancyView {

    @BindView(R.id.progressBar)
    ProgressBar mProgressBar;

    @BindView(R.id.vacancyDetailName)
    TextView mVacancyName;

    @BindView(R.id.vacancyDetailDesc)
    TextView mVacancyDesc;

    @Inject
    DetailVacancyPresenter mPresenter;

    private VacancyDetail mVacancyDetail;
    private View mView;
    private String mID;

    public static Fragment newInstance(String id) {
        Bundle bundle = new Bundle();
        bundle.putString(VacancyDetailActivity.EXTRA_ID, id);
        Fragment fragment = new VacancyDetailFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        mPresenter.attachView(this);
        mID = getArguments().getString(VacancyDetailActivity.EXTRA_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_vacancy_detail, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getVacancyDetail(mID);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView();
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
        Snackbar.make(mView, error, Snackbar.LENGTH_LONG)
                .setAction(R.string.try_again_snack_bar, v -> mPresenter.getVacancyDetail(mID))
                .show();
    }

    @Override
    public void getDetailDone(VacancyDetail vacancyDetail) {
        mVacancyDetail = vacancyDetail;
        fillView();
    }

    private void fillView() {
        if (mVacancyDetail == null || mVacancyDetail.getName() == null) {
            return;
        }
        mVacancyName.setText(mVacancyDetail.getName());
        mVacancyDesc.setText(mVacancyDetail.getDescription());
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mVacancyDesc.setText(Html.fromHtml(mVacancyDetail.getDescription(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            mVacancyDesc.setText(Html.fromHtml(mVacancyDetail.getDescription()));
        }
    }

    public void loadData(String id) {
        mID = id;
        mPresenter.getVacancyDetail(mID);
    }
}
