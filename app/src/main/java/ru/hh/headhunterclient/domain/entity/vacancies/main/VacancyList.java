package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VacancyList extends RealmObject {

    public static final String ITEMS = "items";
    public static final String PAGES = "pages";
    public static final String FOUND = "found";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String PER_PAGE = "per_page";
    public static final String PAGE = "page";

    @SerializedName(ITEMS)
    private RealmList<Vacancy> items;

    @SerializedName(PAGES)
    private int pages;

    @SerializedName(FOUND)
    private int found;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(PER_PAGE)
    private int perPage;

    @SerializedName(PAGE)
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

