package ru.hh.headhunterclient.data.repository.area;

import java.util.List;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.area.Area;

/**
 * Created by neox on 22.09.17.
 */

public interface AreaStore {

    Observable<List<Area>> getAreas();

    void saveAreas(List<Area> countries);

    void clearAreas();

    Observable<List<Area>> searchAreas(String area);
}
