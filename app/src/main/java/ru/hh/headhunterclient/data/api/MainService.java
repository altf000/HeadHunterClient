package ru.hh.headhunterclient.data.api;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import ru.hh.headhunterclient.domain.entity.area.Area;
import ru.hh.headhunterclient.domain.entity.dictionaries.Dictionaries;
import ru.hh.headhunterclient.domain.entity.vacancies.keywords.KeywordsList;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12/9/17.
 */

public interface MainService {

    // список вакансий
    @GET("vacancies")
    Observable<VacancyList> getVacancies(@QueryMap Map<String, String> params);

    // детализация вакансии
    @GET("vacancies/{id}")
    Observable<VacancyDetail> getVacancyDetail(@Path("id") String id);

    @GET("suggests/vacancy_search_keyword")
    Observable<KeywordsList> getKeywords(@Query("text") String keywords);

    // словари
    @GET("dictionaries")
    Observable<Dictionaries> getDictionaries();

    // регионы
    @GET("areas")
    Observable<List<Area>> getAreas();
}
