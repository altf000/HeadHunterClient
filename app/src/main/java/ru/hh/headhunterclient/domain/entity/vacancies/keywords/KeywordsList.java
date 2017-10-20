package ru.hh.headhunterclient.domain.entity.vacancies.keywords;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by neox on 24.09.17.
 */

public class KeywordsList {

    public static final String ITEMS = "items";

    @SerializedName(ITEMS)
    private List<KeywordItem> items;

    public List<KeywordItem> getItems() {
        return items;
    }

    public void setItems(List<KeywordItem> items) {
        this.items = items;
    }
}
