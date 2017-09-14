package ru.hh.headhunterclient.data.repository.vacancy;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import ru.hh.headhunterclient.data.exception.NetworkConnectionException;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12.09.17.
 * Локальное хранилище вакансий
 */

public class VacancyLocalStorage implements VacancyStore {

    @Inject
    public VacancyLocalStorage() {

    }

    @Override
    public Observable<VacancyList> getVacancies(String query, int page) {
        Realm realm = Realm.getDefaultInstance();
        if (ifVacancyListExists(realm)) {
            List<Vacancy> list = realm.copyFromRealm(realm.where(Vacancy.class).findAll());
            realm.close();
            VacancyList vacancyList = new VacancyList();
            vacancyList.setItems(new RealmList<>(list.toArray(new Vacancy[list.size()])));
            return Observable.just(vacancyList);
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
    public void clearVacancyList() {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.delete(Vacancy.class));
        realm.close();
    }

    @Override
    public void saveVacancyList(VacancyList vacancyList) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(vacancyList.getItems()));
        realm.close();
    }

    @Override
    public void saveVacancyDetail(VacancyDetail vacancyDetail) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> realm1.insertOrUpdate(vacancyDetail));
        realm.close();
    }

    private boolean ifVacancyListExists(Realm realm) {
        RealmQuery<Vacancy> query = realm.where(Vacancy.class);
        return query.count() != 0;
    }

    private boolean ifVacancyByIdExists(Realm realm, String id) {
        RealmQuery<VacancyDetail> query = realm.where(VacancyDetail.class).equalTo("id", id);
        return query.count() != 0;
    }
}
