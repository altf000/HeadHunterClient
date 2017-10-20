package ru.hh.headhunterclient.data.repository.dictionary;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;

/**
 * Created by neox on 21.09.17.
 */

public interface DictionaryStore {

    Observable<Dictionaries> getDictionaries();

    void saveDictionaries(Dictionaries dictionaries);

}
