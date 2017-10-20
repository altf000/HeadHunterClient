package ru.hh.headhunterclient.data.repository.vacancy;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmQuery;
import ru.hh.headhunterclient.data.exception.NetworkConnectionException;
import ru.hh.headhunterclient.domain.entity.vacancies.keywords.KeywordsList;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12.09.17.
 * Локальное хранилище вакансий
 */

public class VacancyLocalStorage implements VacancyStore {

    @Inject
    VacancyLocalStorage() {

    }

    @Override
    public Observable<VacancyList> getVacancies(Map<String, String> params) {
        Realm realm = Realm.getDefaultInstance();
        if (ifVacancyListExists(realm)) {
            VacancyList list = realm.copyFromRealm(realm.where(VacancyList.class).findFirst());
            realm.close();
            return Observable.just(list);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }

    @Override
    public Observable<VacancyDetail> getVacancyDetail(String id) {
        Realm realm = Realm.getDefaultInstance();
        if (ifVacancyByIdExists(realm, id)) {
            VacancyDetail vacancy = realm.copyFromRealm(realm.where(VacancyDetail.class).equalTo("id", id).findFirst());
            realm.close();
            return Observable.just(vacancy);
        }
        realm.close();
        return Observable.error(new NetworkConnectionException());
    }

    @Override
    public void saveVacancyList(VacancyList vacancyList, boolean clear) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {
            if (clear) {
                realm1.delete(VacancyList.class);
                realm1.insertOrUpdate(vacancyList);
            } else {
                VacancyList realmList = realm1.copyFromRealm(realm1.where(VacancyList.class).findFirst());
                realmList.getItems().addAll(vacancyList.getItems());
                realm1.delete(VacancyList.class);
                realm1.insertOrUpdate(realmList);
            }
        });
        realm.close();
    }

    @Override
    public void saveVacancyDetail(VacancyDetail vacancyDetail) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(vacancyDetail));
        realm.close();
    }

    @Override
    public Observable<KeywordsList> getKeywords(String keywords) {
        throw new UnsupportedOperationException("You can not get data on local");
    }

    private boolean ifVacancyListExists(Realm realm) {
        RealmQuery<VacancyList> query = realm.where(VacancyList.class);
        return query.count() != 0;
    }

    private boolean ifVacancyByIdExists(Realm realm, String id) {
        RealmQuery<VacancyDetail> query = realm.where(VacancyDetail.class).equalTo("id", id);
        return query.count() != 0;
    }
}
