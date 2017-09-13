package ru.hh.headhunterclient.data.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyDetail;
import ru.hh.headhunterclient.domain.entity.vacancies.main.VacancyList;

/**
 * Created by neox on 12/9/17.
 */

public interface MainService {

    @GET("vacancies")
    Observable<VacancyList> getVacancies(@Query("text") String text);

    @GET("vacancies/{id}")
    Observable<VacancyDetail> getVacancyDetail(@Path("id") String id);

}
