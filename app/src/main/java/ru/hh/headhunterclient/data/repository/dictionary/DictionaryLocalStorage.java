package ru.hh.headhunterclient.data.repository.dictionary;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmQuery;
import ru.hh.headhunterclient.data.exception.NetworkConnectionException;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;

/**
 * Created by neox on 21.09.17.
 * Локальное хранилище словарей
 */
public class DictionaryLocalStorage implements DictionaryStore {

    @Inject
    DictionaryLocalStorage() {

    }

    @Override
    public Observable<Dictionaries> getDictionaries() {
        Realm realm = Realm.getDefaultInstance();
        if (ifDictionaryExists(realm)) {
            Dictionaries dictionaries = realm.copyFromRealm(realm.where(Dictionaries.class).findFirst());
            realm.close();
            return Observable.just(dictionaries);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }

    @Override
    public void saveDictionaries(Dictionaries dictionaries) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(dictionaries));
        realm.close();
    }

    private boolean ifDictionaryExists(Realm realm) {
        RealmQuery<Dictionaries> query = realm.where(Dictionaries.class);
        return query.count() != 0;
    }
}
