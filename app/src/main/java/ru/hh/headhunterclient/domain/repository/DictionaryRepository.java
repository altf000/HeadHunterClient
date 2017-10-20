package ru.hh.headhunterclient.domain.repository;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;

/**
 * Created by neox on 21.09.17.
 */

public interface DictionaryRepository {

    Observable<Dictionaries> getDictionaries();

}
