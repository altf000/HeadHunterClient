package ru.hh.headhunterclient.ui.main;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import ru.hh.headhunterclient.App;
import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.ui.base.BaseViewHolder;
import ru.hh.headhunterclient.utils.VacancyUtils;

/**
 * Created by neox on 12/9/17.
 * Плашка списка вакансий
 */

public class VacancyListViewHolder extends BaseViewHolder {

    @BindView(R.id.cardView)
    CardView mContainer;

    @BindView(R.id.vacancyTitle)
    TextView mTitle;

    @BindView(R.id.vacancySalary)
    TextView mSalary;

    @BindView(R.id.vacancyDesc)
    TextView mDesc;

    @Inject
    VacancyUtils mVacancyUtils;

    public VacancyListViewHolder(View itemView) {
        super(itemView);
        App.getAppComponent().inject(this);
    }

    public void bind(Vacancy vacancy, VacancyListActivity.OnItemSelectedListener itemSelectedListener) {
        mTitle.setText(vacancy.getName());
        mSalary.setText(mVacancyUtils.getSalary(vacancy.getSalary(), itemView.getContext()));
        mDesc.setText(String.format(itemView.getContext().getString(R.string.vacancy_desc), vacancy.getArea().getName(), vacancy.getEmployer().getName()));
        mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemSelectedListener.onItemSelected(vacancy.getId());
            }
        });
    }
}
