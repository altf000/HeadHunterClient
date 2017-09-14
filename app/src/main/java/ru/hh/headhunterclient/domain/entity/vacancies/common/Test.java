package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Test extends RealmObject {

    public static final String REQUIRED = "required";

    @SerializedName(REQUIRED)
    private boolean required;

    public Test() {
    }

    public boolean getRequired() {
        return this.required;
    }

    public Test setRequired(boolean required) {
        this.required = required;
        return this;
    }
}

