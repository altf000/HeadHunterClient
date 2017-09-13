package ru.hh.headhunterclient.utils;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Salary;

/**
 * Created by neox on 11.09.17.
 */

@Singleton
public class VacancyUtils {

    @Inject
    VacancyUtils() {

    }

    public String getSalary(Salary salary, Context context) {
        if (salary == null) {
            return context.getString(R.string.salary_not_found);
        } else if (salary.getFrom() != null && salary.getTo() != null) {
            return String.format(context.getString(R.string.from_to_format), salary.getFrom(), salary.getTo(), salary.getCurrency());
        } else if (salary.getFrom() != null) {
            return String.format(context.getString(R.string.from_format), salary.getFrom(), salary.getCurrency());
        } else {
            return String.format(context.getString(R.string.to_format), salary.getTo(), salary.getCurrency());
        }
    }

}
