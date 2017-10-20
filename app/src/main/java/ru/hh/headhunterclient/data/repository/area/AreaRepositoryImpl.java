package ru.hh.headhunterclient.data.repository.area;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.data.exception.ExceptionFactory;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.domain.repository.AreasRepository;

/**
 * Created by neox on 22.09.17.
 * Репозиторий регионов
 */
public class AreaRepositoryImpl implements AreasRepository {

    private AreaCloudStorage mAreaCloudStorage;
    private AreaLocalStorage mAreaLocalStorage;

    @Inject
    AreaRepositoryImpl(AreaCloudStorage areaCloudStorage, AreaLocalStorage areaLocalStorage) {
        this.mAreaCloudStorage = areaCloudStorage;
        this.mAreaLocalStorage = areaLocalStorage;
    }

    @Override
    public Observable<List<Area>> getAreas() {
        return Observable.create((ObservableOnSubscribe<List<Area>>) e -> mAreaCloudStorage
                .getAreas()
                .subscribe(countries -> {
                    if (!e.isDisposed()) {
                        mAreaLocalStorage.clearAreas();
                        mAreaLocalStorage.saveAreas(countries);
                        e.onNext(countries);
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        e.onError(ExceptionFactory.getException(throwable));
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<Area>> searchAreas(String area) {
        return mAreaLocalStorage.searchAreas(area)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
