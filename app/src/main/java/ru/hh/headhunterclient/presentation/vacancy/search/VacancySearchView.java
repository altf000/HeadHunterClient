package ru.hh.headhunterclient.presentation.vacancy.search;

import java.util.List;

import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.presentation.base.MvpView;

/**
 * Created by neox on 23.09.17.
 */

public interface VacancySearchView extends MvpView {

    void getAreasDone(List<Area> areaList);

}
