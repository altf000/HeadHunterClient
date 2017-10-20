package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancySnippet extends RealmObject {

    public static final String REQUIREMENT = "requirement";
    public static final String RESPONSIBILITY = "responsibility";

    @SerializedName(REQUIREMENT)
    private String requirement;

    @SerializedName(RESPONSIBILITY)
    private String responsibility;

    public VacancySnippet() {
    }

    public String getRequirement() {
        return this.requirement;
    }

    public VacancySnippet setRequirement(String requirement) {
        this.requirement = requirement;
        return this;
    }

    public String getResponsibility() {
        return this.responsibility;
    }

    public VacancySnippet setResponsibility(String responsibility) {
        this.responsibility = responsibility;
        return this;
    }
}

