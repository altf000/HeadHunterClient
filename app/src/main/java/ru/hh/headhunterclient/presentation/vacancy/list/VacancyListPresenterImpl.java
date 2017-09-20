package ru.hh.headhunterclient.presentation.vacancy.list;

import com.f2prateek.rx.preferences2.Preference;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.data.Keywords;
import ru.hh.headhunterclient.domain.entity.search.VacancySearch;
import ru.hh.headhunterclient.domain.entity.vacancies.main.Vacancy;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor;
import ru.hh.headhunterclient.domain.interactor.vacancies.VacancyListInteractor.Params;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 12/9/17.
 * Презентер списка вакансий
 */

public class VacancyListPresenterImpl extends VacancyListPresenter {

    private VacancyListInteractor mVacancyListInterceptor;
    private Preference<String> mQueryPref;
    private VacancySearch mVacancySearch;
    private List<Vacancy> mVacancyList;
    private int mAllItemsCount;

    @Inject
    VacancyListPresenterImpl(VacancyListInteractor vacancyListInteractor, @Keywords Preference<String> queryPref) {
        this.mVacancyListInterceptor = vacancyListInteractor;
        this.mQueryPref = queryPref;
        this.mVacancySearch = new VacancySearch();
        this.mVacancyList = new ArrayList<>();
    }

    @Override
    public void onViewAttached() {
        mVacancySearch.setQuery(mQueryPref.get());
        getView().setQuery(mQueryPref.get());
    }

    @Override
    public void getVacancies(boolean cached) {
        mVacancySearch.setCached(cached);
        mVacancySearch.setPage(0);
        mVacancySearch.setLoadMore(false);
        getVacanciesList();
    }

    @Override
    public void searchVacancies(String query) {
        mVacancySearch.setQuery(query);
        mVacancySearch.setPage(0);
        mVacancySearch.setCached(false);
        mVacancySearch.setLoadMore(false);
        mQueryPref.set(query);
        getVacanciesList();
    }

    @Override
    public void loadMore() {
        if (mAllItemsCount > mVacancyList.size()) {
            mVacancySearch.setLoadMore(true);
            mVacancySearch.setCached(false);
            getVacanciesList();
        }
    }

    private void getVacanciesList() {
        getView().showLoading();
        mVacancyListInterceptor.execute(new VacancyListObserver(), Params.create(mVacancySearch));
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
            if (mVacancySearch.isLoadMore()) {
                mVacancyList.addAll(vacancyList.getItems());
            } else {
                mVacancyList = vacancyList.getItems();
            }
            mAllItemsCount = vacancyList.getFound();
            mVacancySearch.setPage(mVacancyList.size() / vacancyList.getPerPage());
            getView().setSubtitle(String.format(getView().getContext().getString(R.string.vacancy_count), vacancyList.getFound()));
            getView().getVacanciesDone(mVacancyList);
            getView().hideLoading();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(e);
        }
    }
}
