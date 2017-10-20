package ru.hh.headhunterclient.domain.entity.vacancies.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VacancyContacts extends RealmObject {

    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String PHONES = "phones";

    @SerializedName(NAME)
    private String name;

    @SerializedName(EMAIL)
    private String email;

    @SerializedName(PHONES)
    private RealmList<VacancyPhones> phones;

    public VacancyContacts() {
    }

    public String getName() {
        return this.name;
    }

    public VacancyContacts setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public VacancyContacts setEmail(String email) {
        this.email = email;
        return this;
    }

    public RealmList<VacancyPhones> getPhones() {
        return this.phones;
    }

    public VacancyContacts setPhones(RealmList<VacancyPhones> phones) {
        this.phones = phones;
        return this;
    }
}

