package ru.hh.headhunterclient.domain.interactor.vacancies;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.Interactor;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12/9/17.
 */

public class VacancyListInteractor extends Interactor<VacancyList> {

    private VacancyRepository mVacancyRepository;
    private String mQuery;
    private int mPage;
    private boolean mCached;
    private boolean mLoadMore;

    @Inject
    public VacancyListInteractor(VacancyRepository vacancyRepository) {
        this.mVacancyRepository = vacancyRepository;
    }

    @Override
    protected Observable<VacancyList> createObservableInteractor() {
        return mVacancyRepository.getVacancies(mQuery, mPage, mCached, mLoadMore);
    }

    public void setQuery(String query) {
        this.mQuery = query;
    }

    public void setPage(int page) {
        this.mPage = page;
    }

    public void setCached(boolean mCached) {
        this.mCached = mCached;
    }

    public void setLoadMore(boolean mLoadMore) {
        this.mLoadMore = mLoadMore;
    }
}
