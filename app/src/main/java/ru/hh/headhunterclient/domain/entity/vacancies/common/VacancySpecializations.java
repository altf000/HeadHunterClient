package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancySpecializations extends RealmObject {

    public static final String PROFAREA_ID = "profarea_id";
    public static final String PROFAREA_NAME = "profarea_name";
    public static final String ID = "id";
    public static final String NAME = "name";

    @SerializedName(PROFAREA_ID)
    private String profareaID;

    @SerializedName(PROFAREA_NAME)
    private String profareaName;

    @SerializedName(ID)
    private String id;

    @SerializedName(NAME)
    private String name;

    public VacancySpecializations() {
    }

    public String getProfareaID() {
        return this.profareaID;
    }

    public VacancySpecializations setProfareaID(String profareaID) {
        this.profareaID = profareaID;
        return this;
    }

    public String getProfareaName() {
        return this.profareaName;
    }

    public VacancySpecializations setProfareaName(String profareaName) {
        this.profareaName = profareaName;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public VacancySpecializations setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public VacancySpecializations setName(String name) {
        this.name = name;
        return this;
    }
}

