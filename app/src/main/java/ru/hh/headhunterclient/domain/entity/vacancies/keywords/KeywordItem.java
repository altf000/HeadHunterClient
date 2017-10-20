package ru.hh.headhunterclient.domain.entity.vacancies.keywords;

import com.google.gson.annotations.SerializedName;

/**
 * Created by neox on 24.09.17.
 */

public class KeywordItem {

    public static final String TEXT = "text";

    @SerializedName(TEXT)
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
