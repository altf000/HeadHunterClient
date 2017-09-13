package ru.hh.headhunterclient.domain.entity.vacancies.common;

import io.realm.RealmObject;

public class Relations extends RealmObject {

    public static final String VALUE = "value";

    private String value;

    public Relations() {
    }

    public String getValue() {
        return this.value;
    }

    public Relations setValue(String value) {
        this.value = value;
        return this;
    }
}

