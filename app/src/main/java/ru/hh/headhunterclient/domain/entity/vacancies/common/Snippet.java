package ru.hh.headhunterclient.domain.entity.vacancies.common;

import io.realm.RealmObject;

public class Snippet extends RealmObject {

    public static final String REQUIREMENT = "requirement";
    public static final String RESPONSIBILITY = "responsibility";

    private String requirement;
    private String responsibility;

    public Snippet() {
    }

    public String getRequirement() {
        return this.requirement;
    }

    public Snippet setRequirement(String requirement) {
        this.requirement = requirement;
        return this;
    }

    public String getResponsibility() {
        return this.responsibility;
    }

    public Snippet setResponsibility(String responsibility) {
        this.responsibility = responsibility;
        return this;
    }
}

