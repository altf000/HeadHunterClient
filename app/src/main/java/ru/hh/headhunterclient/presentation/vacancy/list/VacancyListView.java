package ru.hh.headhunterclient.presentation.vacancy.list;

import java.util.List;

import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.presentation.base.MvpView;

/**
 * Created by neox on 12/9/17.
 */

public interface VacancyListView extends MvpView {

    void getVacanciesDone(List<Vacancy> vacancyList);

    void setSubtitle(String subtitle);

    void setQuery(String query);

    void getKeywordsDone(List<String> keywords);

}
