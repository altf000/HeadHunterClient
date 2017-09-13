package ru.hh.headhunterclient;

import javax.inject.Singleton;

import dagger.Component;
import ru.hh.headhunterclient.ui.detail.VacancyDetailActivity;
import ru.hh.headhunterclient.ui.detail.VacancyDetailFragment;
import ru.hh.headhunterclient.ui.main.VacancyListActivity;
import ru.hh.headhunterclient.ui.main.VacancyListFragment;
import ru.hh.headhunterclient.ui.main.VacancyListViewHolder;

/**
 * Created by neox on 12/9/17.
 */

@Singleton
@Component(
        modules = {
                AppModule.class
        }
)
public interface AppComponent {

    void inject(VacancyListActivity vacancyListActivity);

    void inject(VacancyDetailActivity vacancyDetailActivity);

    void inject(VacancyListFragment vacancyListFragment);

    void inject(VacancyListViewHolder vacancyListViewHolder);

    void inject(VacancyDetailFragment vacancyDetailFragment);

}
