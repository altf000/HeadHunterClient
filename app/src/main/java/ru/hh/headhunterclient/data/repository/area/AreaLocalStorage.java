package ru.hh.headhunterclient.data.repository.area;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmQuery;
import ru.hh.headhunterclient.data.exception.NoDataException;
import ru.hh.headhunterclient.domain.entity.area.Area;

/**
 * Created by neox on 22.09.17.
 */

public class AreaLocalStorage implements AreaStore {

    @Inject
    AreaLocalStorage() {

    }

    @Override
    public Observable<List<Area>> getAreas() {
        Realm realm = Realm.getDefaultInstance();
        if (ifAreasExists(realm)) {
            List<Area> list = realm.copyFromRealm(realm.where(Area.class).findAll());
            realm.close();
            return Observable.just(list);
        }
        realm.close();
        return Observable.error(new NoDataException());
    }

    @Override
    public void saveAreas(List<Area> countries) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(countries));
        realm.close();
    }

    @Override
    public void clearAreas() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.delete(Area.class));
        realm.close();
    }

    @Override
    public Observable<List<Area>> searchAreas(String area) {
        Realm realm = Realm.getDefaultInstance();
        if (ifAreasSearchExists(realm, area)) {
            List<Area> list = realm.copyFromRealm(realm.where(Area.class).contains("name", area).findAll());
            realm.close();
            if (list.size() >= 3) {
                return Observable.just(list.subList(0, 3));
            } else {
                return Observable.just(list);
            }
        } else {
            realm.close();
            return Observable.error(new NoDataException());
        }
    }

    private boolean ifAreasExists(Realm realm) {
        RealmQuery<Area> query = realm.where(Area.class);
        return query.count() != 0;
    }

    private boolean ifAreasSearchExists(Realm realm, String text) {
        RealmQuery<Area> query = realm.where(Area.class).contains("name", text);
        return query.count() != 0;
    }

}
