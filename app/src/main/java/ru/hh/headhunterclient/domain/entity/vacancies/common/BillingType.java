package ru.hh.headhunterclient.domain.entity.vacancies.common;

import io.realm.RealmObject;

public class BillingType extends RealmObject {

    public static final String ID = "id";
    public static final String NAME = "name";

    private String id;
    private String name;

    public BillingType() {
    }

    public String getId() {
        return this.id;
    }

    public BillingType setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public BillingType setName(String name) {
        this.name = name;
        return this;
    }
}

