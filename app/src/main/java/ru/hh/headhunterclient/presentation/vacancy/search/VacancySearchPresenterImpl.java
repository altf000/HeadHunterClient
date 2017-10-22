package ru.hh.headhunterclient.presentation.vacancy.search;

import java.util.List;

import javax.inject.Inject;

import ru.hh.headhunterclient.R;
import ru.hh.headhunterclient.data.exception.NoDataException;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.domain.interactor.area.AreaSearchInteractor;
import ru.hh.headhunterclient.domain.interactor.base.InteractorObserver;
import ru.hh.headhunterclient.presentation.exception.ErrorMessageFactory;

/**
 * Created by neox on 23.09.17.
 */
public class VacancySearchPresenterImpl extends VacancySearchPresenter {

    private AreaSearchInteractor mSearchInteractor;

    @Inject
    VacancySearchPresenterImpl(AreaSearchInteractor searchInteractor) {
        this.mSearchInteractor = searchInteractor;
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void getAreas(String query) {
        getView().showLoading();
        mSearchInteractor.execute(new VacancyListObserver(), AreaSearchInteractor.Params.create(query));
    }

    @Override
    public void detachView() {
        if (mSearchInteractor != null) {
            mSearchInteractor.dispose();
        }
    }

    private void showErrorMessage(Throwable throwable) {
        getView().hideLoading();
        getView().showError(ErrorMessageFactory.create(getView().getContext(), throwable));
    }

    private void showErrorMessage(String message) {
        getView().hideLoading();
        getView().showError(message);
    }

    private final class VacancyListObserver extends InteractorObserver<List<Area>> {
        @Override
        public void onNext(List<Area> areas) {
            getView().hideLoading();
            getView().getAreasDone(areas);
        }

        @Override
        public void onError(Throwable e) {
            if (e instanceof NoDataException) {
                showErrorMessage(getView().getContext().getString(R.string.region_not_found));
            } else {
                showErrorMessage(e);
            }
        }
    }
}
