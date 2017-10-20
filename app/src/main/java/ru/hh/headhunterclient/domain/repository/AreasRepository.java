package ru.hh.headhunterclient.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.area.Area;

/**
 * Created by neox on 22.09.17.
 */

public interface AreasRepository {

    Observable<List<Area>> getAreas();

    Observable<List<Area>> searchAreas(String area);

}
