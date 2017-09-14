package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class KeySkills extends RealmObject {

    public static final String NAME = "name";

    @SerializedName(NAME)
    private String name;

    public KeySkills() {
    }

    public String getName() {
        return this.name;
    }

    public KeySkills setName(String name) {
        this.name = name;
        return this;
    }
}

