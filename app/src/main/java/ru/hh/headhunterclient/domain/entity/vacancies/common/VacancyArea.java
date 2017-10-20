package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancyArea extends RealmObject {

    public static final String URL = "url";
    public static final String ID = "id";
    public static final String NAME = "name";

    @SerializedName(URL)
    private String url;

    @SerializedName(ID)
    private String id;

    @SerializedName(NAME)
    private String name;

    public VacancyArea() {
    }

    public String getUrl() {
        return this.url;
    }

    public VacancyArea setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public VacancyArea setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public VacancyArea setName(String name) {
        this.name = name;
        return this;
    }
}

