package ru.hh.headhunterclient.data.repository.vacancy;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.hh.headhunterclient.data.exception.ExceptionFactory;
import ru.hh.headhunterclient.data.pref.VacancyFilter;
import ru.hh.headhunterclient.domain.entity.vacancies.keywords.KeywordItem;
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
    private VacancyFilter mVacancyFilter;

    @Inject
    VacancyRepositoryImpl(VacancyCloudStorage vacancyCloudStorage, VacancyLocalStorage vacancyLocalStorage) {
        this.mVacancyCloudStorage = vacancyCloudStorage;
        this.mVacancyLocalStorage = vacancyLocalStorage;
    }

    @Override
    public Observable<VacancyList> getVacancies(VacancyFilter vacancyFilter) {
        mVacancyFilter = vacancyFilter;
        return Observable.create((ObservableOnSubscribe<VacancyList>) e -> {
            if (mVacancyFilter.isCached()) {
                // вакансии из бд
                mVacancyLocalStorage
                        .getVacancies(mVacancyFilter.toGetParams())
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
                        .getVacancies(mVacancyFilter.toGetParams())
                        .doOnNext(vacancyList -> mVacancyLocalStorage.saveVacancyList(vacancyList, !mVacancyFilter.isLoadMore()))
                        .subscribe(vacancyList -> {
                            if (!e.isDisposed()) {
                                mVacancyFilter.setPage(vacancyList.getPage() + 1);
                                e.onNext(vacancyList);
                            }
                        }, throwable -> {
                            if (!e.isDisposed()) {
                                getVacanciesFromLocalStorage(e, throwable);
                            }
                        });
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread(), true);
    }

    private void getVacanciesFromLocalStorage(ObservableEmitter<VacancyList> e, Throwable t) {
        // вакансии из бд в случае ошибки получения данны из сети
        mVacancyLocalStorage
                .getVacancies(mVacancyFilter.toGetParams())
                .subscribe(vacancyList -> {
                    if (!e.isDisposed()) {
                        if (!mVacancyFilter.isLoadMore()) {
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

    @Override
    public Observable<List<String>> getKeywords(String keywords) {
        return Observable.create((ObservableOnSubscribe<List<String>>) e -> mVacancyCloudStorage
                .getKeywords(keywords)
                .subscribe(vacancySearchKeywords -> {
                    if (!e.isDisposed()) {
                        List<String> list = Stream.of(vacancySearchKeywords.getItems())
                                .map(KeywordItem::getText)
                                .collect(Collectors.toList());
                        e.onNext(list);
                    }
                }, throwable -> {
                    if (!e.isDisposed()) {
                        e.onError(ExceptionFactory.getException(throwable));
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
