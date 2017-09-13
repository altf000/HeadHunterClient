package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by neox on 12.09.17.
 * Сгенерированные классы! Прошу не обращать внимание на code conventions
 */

public class VacancyList extends RealmObject {

    public static final String ITEMS = "items";
    public static final String PAGES = "pages";
    public static final String FOUND = "found";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";

    private RealmList<Vacancy> items;
    private int pages;
    private int found;
    @SerializedName("alternate_url")
    private String alternateUrl;
    @SerializedName("per_page")
    private int perPage;
    private int page;

    public VacancyList() {
    }

    public RealmList<Vacancy> getItems() {
        return this.items;
    }

    public VacancyList setItems(RealmList<Vacancy> items) {
        this.items = items;
        return this;
    }

    public int getPages() {
        return this.pages;
    }

    public VacancyList setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public int getFound() {
        return this.found;
    }

    public VacancyList setFound(int found) {
        this.found = found;
        return this;
    }

    public String getAlternateUrl() {
        return this.alternateUrl;
    }

    public VacancyList setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
        return this;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public VacancyList setPerPage(int perPage) {
        this.perPage = perPage;
        return this;
    }

    public int getPage() {
        return this.page;
    }

    public VacancyList setPage(int page) {
        this.page = page;
        return this;
    }
}

