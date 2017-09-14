package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Relations extends RealmObject {

    public static final String VALUE = "value";

    @SerializedName(VALUE)
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

