package ru.hh.headhunterclient.data.repository.dictionary;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.data.exception.ExceptionFactory;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;
import ru.hh.headhunterclient.domain.repository.DictionaryRepository;

/**
 * Created by neox on 21.09.17.
 * Репозиторий словарей
 */
public class DictionaryRepositoryImpl implements DictionaryRepository {

    private DictionaryCloudStorage mDictionaryCloudStorage;
    private DictionaryLocalStorage mDictionaryLocalStorage;

    @Inject
    DictionaryRepositoryImpl(DictionaryCloudStorage dictionaryCloudStorage, DictionaryLocalStorage dictionaryLocalStorage) {
        this.mDictionaryCloudStorage = dictionaryCloudStorage;
        this.mDictionaryLocalStorage = dictionaryLocalStorage;
    }

    @Override
    public Observable<Dictionaries> getDictionaries() {
        return Observable.create((ObservableOnSubscribe<Dictionaries>) e -> mDictionaryCloudStorage
                .getDictionaries()
                .subscribe(dictionaries -> {
                    if (!e.isDisposed()) {
                        mDictionaryLocalStorage.saveDictionaries(dictionaries);
                        e.onNext(dictionaries);
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        e.onError(ExceptionFactory.getException(throwable));
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
