package ru.hh.headhunterclient.domain.entity.vacancies.contacts;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancyPhones extends RealmObject {

    public static final String COUNTRY = "country";
    public static final String CITY = "city";
    public static final String NUMBER = "number";

    @SerializedName(COUNTRY)
    private String country;

    @SerializedName(CITY)
    private String city;

    @SerializedName(NUMBER)
    private String number;

    public VacancyPhones() {
    }

    public String getCountry() {
        return this.country;
    }

    public VacancyPhones setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public VacancyPhones setCity(String city) {
        this.city = city;
        return this;
    }

    public String getNumber() {
        return this.number;
    }

    public VacancyPhones setNumber(String number) {
        this.number = number;
        return this;
    }
}

