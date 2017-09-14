package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Experience extends RealmObject {

    public static final String ID = "id";
    public static final String NAME = "name";

    @SerializedName(ID)
    private String id;

    @SerializedName(NAME)
    private String name;

    public Experience() {
    }

    public String getId() {
        return this.id;
    }

    public Experience setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Experience setName(String name) {
        this.name = name;
        return this;
    }
}

