package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Test extends RealmObject {

    public static final String REQUIRED = "required";

    @SerializedName(REQUIRED)
    private Boolean required;

    public Test() {
    }

    public Boolean getRequired() {
        return this.required;
    }

    public Test setRequired(Boolean required) {
        this.required = required;
        return this;
    }
}

