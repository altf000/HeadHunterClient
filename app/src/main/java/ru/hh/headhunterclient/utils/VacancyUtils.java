package ru.hh.headhunterclient.utils;

import android.content.Context;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancySalary;

/**
 * Created by neox on 11.09.17.
 * Утилиты вакансий
 */
public class VacancyUtils {

    public String getSalary(VacancySalary salary, Context context) {
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
