package ru.hh.headhunterclient.domain.entity.vacancies.common;

import io.realm.RealmObject;

public class Area extends RealmObject {

    public static final String URL = "url";
    public static final String ID = "id";
    public static final String NAME = "name";

    private String url;
    private String id;
    private String name;

    public Area() {
    }

    public String getUrl() {
        return this.url;
    }

    public Area setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Area setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }
}

