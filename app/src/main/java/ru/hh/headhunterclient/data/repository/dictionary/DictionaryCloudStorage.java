package ru.hh.headhunterclient.data.repository.dictionary;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.data.api.MainService;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;

/**
 * Created by neox on 21.09.17.
 * Облачное хранилище словарей
 */
public class DictionaryCloudStorage implements DictionaryStore {

    private MainService mMainService;

    @Inject
    DictionaryCloudStorage(MainService mainService) {
        this.mMainService = mainService;
    }


    @Override
    public Observable<Dictionaries> getDictionaries() {
        return mMainService.getDictionaries();
    }

    @Override
    public void saveDictionaries(Dictionaries dictionaries) {
        throw new UnsupportedOperationException("You can not save or remove data on cloud");
    }

}
