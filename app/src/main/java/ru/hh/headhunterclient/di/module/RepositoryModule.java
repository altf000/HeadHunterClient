package ru.hh.headhunterclient.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.hh.headhunterclient.data.repository.area.AreaRepositoryImpl;
import ru.hh.headhunterclient.data.repository.dictionary.DictionaryRepositoryImpl;
import ru.hh.headhunterclient.data.repository.vacancy.VacancyRepositoryImpl;
import ru.hh.headhunterclient.domain.repository.AreasRepository;
import ru.hh.headhunterclient.domain.repository.DictionaryRepository;
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

    @Provides
    @Singleton
    DictionaryRepository provideDictionaryRepository(DictionaryRepositoryImpl dictionaryRepository) {
        return dictionaryRepository;
    }

    @Provides
    @Singleton
    AreasRepository provideAreaRepository(AreaRepositoryImpl areaRepository) {
        return areaRepository;
    }

}
