package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancyEmployer extends RealmObject {

    public static final String LOGO_URLS = "logo_urls";
    public static final String VACANCIES_URL = "vacancies_url";
    public static final String NAME = "name";
    public static final String URL = "url";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String ID = "id";
    public static final String TRUSTED = "trusted";

    @SerializedName(VACANCIES_URL)
    private String vacanciesUrl;

    @SerializedName(NAME)
    private String name;

    @SerializedName(URL)
    private String url;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(ID)
    private String id;

    @SerializedName(TRUSTED)
    private Boolean trusted;

    public VacancyEmployer() {
    }

    public String getVacanciesUrl() {
        return this.vacanciesUrl;
    }

    public VacancyEmployer setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public VacancyEmployer setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public VacancyEmployer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAlternateUrl() {
        return this.alternateUrl;
    }

    public VacancyEmployer setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public VacancyEmployer setId(String id) {
        this.id = id;
        return this;
    }

    public Boolean getTrusted() {
        return this.trusted;
    }

    public VacancyEmployer setTrusted(Boolean trusted) {
        this.trusted = trusted;
        return this;
    }
}

