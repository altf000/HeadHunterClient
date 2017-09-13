package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Employer extends RealmObject {

    public static final String LOGO_URLS = "logo_urls";
    public static final String VACANCIES_URL = "vacancies_url";
    public static final String NAME = "name";
    public static final String URL = "url";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String ID = "id";
    public static final String TRUSTED = "trusted";

    @SerializedName("vacancies_url")
    private String vacanciesUrl;
    private String name;
    private String url;
    @SerializedName("alternate_url")
    private String alternateUrl;
    private String id;
    private boolean trusted;

    public Employer() {
    }

    public String getVacanciesUrl() {
        return this.vacanciesUrl;
    }

    public Employer setVacanciesUrl(String vacanciesUrl) {
        this.vacanciesUrl = vacanciesUrl;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Employer setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Employer setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getAlternateUrl() {
        return this.alternateUrl;
    }

    public Employer setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Employer setId(String id) {
        this.id = id;
        return this;
    }

    public boolean getTrusted() {
        return this.trusted;
    }

    public Employer setTrusted(boolean trusted) {
        this.trusted = trusted;
        return this;
    }
}

