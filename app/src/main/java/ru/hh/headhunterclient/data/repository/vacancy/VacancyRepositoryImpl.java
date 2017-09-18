package ru.hh.headhunterclient.data.repository.vacancy;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.data.exception.ExceptionFactory;
import ru.hh.headhunterclient.domain.entity.search.VacancySearch;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12/9/17.
 * Репозиторий вакансий
 */
public class VacancyRepositoryImpl implements VacancyRepository {

    private VacancyCloudStorage mVacancyCloudStorage;
    private VacancyLocalStorage mVacancyLocalStorage;

    @Inject
    VacancyRepositoryImpl(VacancyCloudStorage vacancyCloudStorage, VacancyLocalStorage vacancyLocalStorage) {
        this.mVacancyCloudStorage = vacancyCloudStorage;
        this.mVacancyLocalStorage = vacancyLocalStorage;
    }

    @Override
    public Observable<VacancyList> getVacancies(VacancySearch vacancySearch) {
        return Observable.create((ObservableOnSubscribe<VacancyList>) e -> {
            if (vacancySearch.isCached()) {
                // вакансии из бд
                mVacancyLocalStorage
                        .getVacancies(vacancySearch.getQuery(), vacancySearch.getPage())
                        .subscribe(vacancyList -> {
                            if (!e.isDisposed()) {
                                e.onNext(vacancyList);
                            }
                        }, throwable -> {
                            if (!e.isDisposed()) {
                                e.onError(ExceptionFactory.getException(throwable));
                            }
                        });
            } else {
                // вакансии из сети
                mVacancyCloudStorage
                        .getVacancies(vacancySearch.getQuery(), vacancySearch.getPage())
                        .doOnNext(vacancyList -> mVacancyLocalStorage.saveVacancyList(vacancyList, !vacancySearch.isLoadMore()))
                        .subscribe(vacancyList -> {
                            if (!e.isDisposed()) {
                                e.onNext(vacancyList);
                            }
                        }, throwable -> {
                            if (!e.isDisposed()) {
                                getVacanciesFromLocalStorage(e, throwable, vacancySearch.isLoadMore());
                            }
                        });
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
    }

    private void getVacanciesFromLocalStorage(ObservableEmitter<VacancyList> e, Throwable t, boolean loadMore) {
        // вакансии из бд в случае ошибки получения данны из сети
        mVacancyLocalStorage
                .getVacancies(null, 0)
                .subscribe(vacancyList -> {
                    if (!e.isDisposed()) {
                        if (!loadMore) {
                            e.onNext(vacancyList);
                        }
                        e.onError(ExceptionFactory.getException(t));
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        e.onError(ExceptionFactory.getException(throwable));
                    }
                });
    }

    @Override
    public Observable<VacancyDetail> getVacancyDetail(String id) {
        return Observable.create((ObservableOnSubscribe<VacancyDetail>) e -> mVacancyCloudStorage
                .getVacancyDetail(id)
                .doOnNext(vacancyDetail -> mVacancyLocalStorage.saveVacancyDetail(vacancyDetail))
                .subscribe(vacancyFull -> {
                    if (!e.isDisposed()) {
                        e.onNext(vacancyFull);
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        getVacancyDetailFromLocalStorage(e, throwable, id);
                    }
                }))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
    }

    private void getVacancyDetailFromLocalStorage(ObservableEmitter<VacancyDetail> e, Throwable t, String id) {
        mVacancyLocalStorage
                .getVacancyDetail(id)
                .subscribe(vacancyDetail -> {
                    if (!e.isDisposed()) {
                        e.onNext(vacancyDetail);
                        e.onError(ExceptionFactory.getException(t));
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        e.onError(ExceptionFactory.getException(throwable));
                    }
                });
    }
}
