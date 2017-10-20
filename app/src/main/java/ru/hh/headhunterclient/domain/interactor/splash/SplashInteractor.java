package ru.hh.headhunterclient.domain.interactor.splash;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.AreasRepository;
import ru.hh.headhunterclient.domain.repository.DictionaryRepository;

/**
 * Created by neox on 21.09.17.
 * Сплеш экран
 */
public class SplashInteractor extends Interactor<Boolean, Void> {

    private DictionaryRepository mDictionaryRepository;
    private AreasRepository mAreaRepository;

    @Inject
    SplashInteractor(DictionaryRepository dictionaryRepository, AreasRepository areasRepository) {
        this.mDictionaryRepository = dictionaryRepository;
        this.mAreaRepository = areasRepository;
    }

    @Override
    protected Observable<Boolean> createObservableInteractor(Void aVoid) {
        return getDictionaries()
                .flatMap(new Function<Dictionaries, ObservableSource<List<Area>>>() {
                    @Override
                    public ObservableSource<List<Area>> apply(@NonNull Dictionaries dictionaries) throws Exception {
                        return getAreas();
                    }
                })
                .flatMap(new Function<List<Area>, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(@NonNull List<Area> countries) throws Exception {
                        return Observable.just(true);
                    }
                });
    }

    private Observable<Dictionaries> getDictionaries() {
        return mDictionaryRepository.getDictionaries();
    }

    private Observable<List<Area>> getAreas() {
        return mAreaRepository.getAreas();
    }
}
