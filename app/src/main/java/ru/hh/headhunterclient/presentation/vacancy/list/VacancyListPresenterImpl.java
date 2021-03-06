package ru.hh.headhunterclient.presentation.vacancy.list;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.data.settings.VacancyFilter;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyKeywordsInteractor;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor.Params;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 12/9/17.
 * Презентер списка вакансий
 */
public class VacancyListPresenterImpl extends VacancyListPresenter {

    private VacancyKeywordsInteractor mVacancyKeywordsInteractor;
    private VacancyListInteractor mVacancyListInterceptor;
    private VacancyFilter mVacancyFilter;
    private List<Vacancy> mVacancyList;
    private int mAllItemsCount;

    @Inject
    VacancyListPresenterImpl(VacancyListInteractor vacancyListInteractor,
                             VacancyKeywordsInteractor vacancyKeywordsInteractor, VacancyFilter vacancyFilter) {
        this.mVacancyListInterceptor = vacancyListInteractor;
        this.mVacancyKeywordsInteractor = vacancyKeywordsInteractor;
        this.mVacancyFilter = vacancyFilter;
        this.mVacancyList = new ArrayList<>();
    }

    @Override
    public void onViewAttached() {
        getView().setQuery(mVacancyFilter.getKeywords());
    }

    @Override
    public void getVacancies(boolean cached) {
        mVacancyFilter.setCached(cached);
        mVacancyFilter.setPage(0);
        mVacancyFilter.setLoadMore(false);
        getVacanciesList();
    }

    @Override
    public void searchVacancies(String query) {
        mVacancyFilter.setPage(0);
        mVacancyFilter.setCached(false);
        mVacancyFilter.setLoadMore(false);
        mVacancyFilter.setKeywords(query);
        getVacanciesList();
    }

    @Override
    public void loadMore() {
        if (mAllItemsCount > mVacancyList.size()) {
            mVacancyFilter.setLoadMore(true);
            mVacancyFilter.setCached(false);
            getVacanciesList();
        }
    }

    @Override
    public void getKeywords(String text) {
        mVacancyKeywordsInteractor.execute(new VacancyKeywordsObserver(), VacancyKeywordsInteractor.Params.create(text));
    }

    private void getVacanciesList() {
        getView().showLoading();
        mVacancyListInterceptor.execute(new VacancyListObserver(), Params.create(mVacancyFilter));
    }

    @Override
    public void detachView() {
        if (mVacancyListInterceptor != null) {
            mVacancyListInterceptor.dispose();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoading();
        getView().showError(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    private final class VacancyListObserver extends InteractorObserver<VacancyList> {

        @Override
        public void onNext(VacancyList vacancyList) {
            if (mVacancyFilter.isLoadMore()) {
                mVacancyList.addAll(vacancyList.getItems());
            } else {
                mVacancyList = vacancyList.getItems();
            }
            mAllItemsCount = vacancyList.getFound();
            mVacancyFilter.setPage(mVacancyList.size() / vacancyList.getPerPage());
            getView().setSubtitle(String.format(getView().getContext().getString(R.string.vacancy_count), vacancyList.getFound()));
            getView().getVacanciesDone(mVacancyList);
            getView().hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }

    private final class VacancyKeywordsObserver extends InteractorObserver<List<String>> {

        @Override
        public void onNext(List<String> keywords) {
            getView().getKeywordsDone(keywords);
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
