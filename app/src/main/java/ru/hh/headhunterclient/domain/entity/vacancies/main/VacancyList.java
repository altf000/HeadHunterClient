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
    private Integer pages;

    @SerializedName(FOUND)
    private Integer found;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(PER_PAGE)
    private Integer perPage;

    @SerializedName(PAGE)
    private Integer page;

    public VacancyList() {
    }

    public RealmList<Vacancy> getItems() {
        return items;
    }

    public void setItems(RealmList<Vacancy> items) {
        this.items = items;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getFound() {
        return found;
    }

    public void setFound(Integer found) {
        this.found = found;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}

