package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Specializations extends RealmObject {

    public static final String PROFAREA_ID = "profarea_id";
    public static final String PROFAREA_NAME = "profarea_name";
    public static final String ID = "id";
    public static final String NAME = "name";

    @SerializedName("profarea_id")
    private String profareaID;
    @SerializedName("profarea_name")
    private String profareaName;
    private String id;
    private String name;

    public Specializations() {
    }

    public String getProfareaID() {
        return this.profareaID;
    }

    public Specializations setProfareaID(String profareaID) {
        this.profareaID = profareaID;
        return this;
    }

    public String getProfareaName() {
        return this.profareaName;
    }

    public Specializations setProfareaName(String profareaName) {
        this.profareaName = profareaName;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Specializations setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Specializations setName(String name) {
        this.name = name;
        return this;
    }
}

