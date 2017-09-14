package ru.hh.headhunterclient.domain.entity.vacancies.common;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Salary extends RealmObject {

    public static final String GROSS = "gross";
    public static final String FROM = "from";
    public static final String CURRENCY = "currency";
    public static final String TO = "to";

    @SerializedName(GROSS)
    private boolean gross;

    @SerializedName(FROM)
    private Long from;

    @SerializedName(CURRENCY)
    private String currency;

    @SerializedName(TO)
    private Long to;

    public Salary() {
    }

    public boolean getGross() {
        return this.gross;
    }

    public Salary setGross(boolean gross) {
        this.gross = gross;
        return this;
    }

    public Long getFrom() {
        return this.from;
    }

    public Salary setFrom(Long from) {
        this.from = from;
        return this;
    }

    public String getCurrency() {
        return this.currency;
    }

    public Salary setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getTo() {
        return this.to;
    }

    public Salary setTo(Long to) {
        this.to = to;
        return this;
    }
}

