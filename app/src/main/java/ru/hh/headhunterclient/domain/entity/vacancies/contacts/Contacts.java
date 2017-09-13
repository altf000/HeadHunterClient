package ru.hh.headhunterclient.domain.entity.vacancies.contacts;

import io.realm.RealmList;
import io.realm.RealmObject;

public class Contacts extends RealmObject {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONES = "phones";

    private String name;
    private String email;
    private RealmList<Phones> phones;

    public Contacts() {
    }

    public String getName() {
        return this.name;
    }

    public Contacts setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public Contacts setEmail(String email) {
        this.email = email;
        return this;
    }

    public RealmList<Phones> getPhones() {
        return this.phones;
    }

    public Contacts setPhones(RealmList<Phones> phones) {
        this.phones = phones;
        return this;
    }
}

