package ru.hh.headhunterclient.data.repository.area;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.data.api.MainService;
import ru.hh.headhunterclient.domain.entity.area.Area;

/**
 * Created by neox on 22.09.17.
 */

public class AreaCloudStorage implements AreaStore {

    private MainService mMainService;

    @Inject
    AreaCloudStorage(MainService mainService) {
        this.mMainService = mainService;
    }

    @Override
    public Observable<List<Area>> getAreas() {
        return mMainService.getAreas();
    }

    @Override
    public void saveAreas(List<Area> countries) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public void clearAreas() {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

    @Override
    public Observable<List<Area>> searchAreas(String area) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }
}
