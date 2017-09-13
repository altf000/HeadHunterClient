package ru.hh.headhunterclient.data.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.data.repository.vacancy.VacancyRepositoryImpl;
import ru.hh.headhunterclient.domain.repository.VacancyRepository;

/**
 * Created by neox on 12/9/17.
 */

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    VacancyRepository provideVacancyRepository(VacancyRepositoryImpl vacancyRepository) {
        return vacancyRepository;
    }

}
