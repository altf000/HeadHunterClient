package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class VacancySalary extends RealmObject {

    public static final String GROSS = "gross";
    public static final String FROM = "from";
    public static final String CURRENCY = "currency";
    public static final String TO = "to";

    @SerializedName(GROSS)
    private Boolean gross;

    @SerializedName(FROM)
    private Long from;

    @SerializedName(CURRENCY)
    private String currency;

    @SerializedName(TO)
    private Long to;

    public VacancySalary() {
    }

    public Boolean getGross() {
        return this.gross;
    }

    public VacancySalary setGross(Boolean gross) {
        this.gross = gross;
        return this;
    }

    public Long getFrom() {
        return this.from;
    }

    public VacancySalary setFrom(Long from) {
        this.from = from;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    public VacancySalary setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getTo() {
        return this.to;
    }

    public VacancySalary setTo(Long to) {
        this.to = to;
        return this;
    }
}

