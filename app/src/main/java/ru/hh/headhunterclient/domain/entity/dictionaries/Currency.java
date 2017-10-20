package ru.hh.headhunterclient.domain.entity.dictionaries;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class Currency extends RealmObject {

    public static final String RATE = "rate";
    public static final String CODE = "code";
    public static final String ABBR = "abbr";
    public static final String IN_USE = "in_use";
    public static final String DEFAULT = "default";
    public static final String NAME = "name";

    @SerializedName(RATE)
    private float rate;

    @SerializedName(CODE)
    private String code;

    @SerializedName(ABBR)
    private String abbr;

    @SerializedName(IN_USE)
    private boolean in_use;

    @SerializedName(DEFAULT)
    private boolean def;

    @SerializedName(NAME)
    private String name;

    public Currency() {
    }

    public float getRate() {
        return this.rate;
    }

    public Currency setRate(float rate) {
        this.rate = rate;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Currency setCode(String code) {
        this.code = code;
        return this;
    }

    public String getAbbr() {
        return this.abbr;
    }

    public Currency setAbbr(String abbr) {
        this.abbr = abbr;
        return this;
    }

    public boolean getIn_use() {
        return this.in_use;
    }

    public Currency setIn_use(boolean in_use) {
        this.in_use = in_use;
        return this;
    }

    public boolean getDefault() {
        return this.def;
    }

    public Currency setDefault(boolean defa) {
        this.def = def;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Currency setName(String name) {
        this.name = name;
        return this;
    }
}

