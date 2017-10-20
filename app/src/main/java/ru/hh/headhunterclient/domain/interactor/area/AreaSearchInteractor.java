package ru.hh.headhunterclient.domain.interactor.area;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.AreasRepository;

/**
 * Created by neox on 23.09.17.
 * Поиск регионов
 */
public class AreaSearchInteractor extends Interactor<List<Area>, AreaSearchInteractor.Params> {

    private AreasRepository mAreaRepository;

    @Inject
    AreaSearchInteractor(AreasRepository areasRepository) {
        this.mAreaRepository = areasRepository;
    }

    @Override
    protected Observable<List<Area>> createObservableInteractor(Params params) {
        return mAreaRepository.searchAreas(params.query);
    }

    public static final class Params {

        private final String query;

        private Params(String query) {
            this.query = query;
        }

        public static Params create(String query) {
            return new Params(query);
        }
    }
}
