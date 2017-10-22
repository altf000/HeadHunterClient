package ru.hh.headhunterclient.data.pref;

import com.f2prateek.rx.preferences2.Preference;
import com.f2prateek.rx.preferences2.RxSharedPreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by neox on 23.09.17.
 * Фильтрация вакансий
 */
public class VacancyFilter {

    public static final String KEY_KEYWORDS = "keywords";
    public static final String KEY_AREA_ID = "area_id";
    public static final String KEY_AREA_NAME = "area_name";
    public static final String KEY_PAGE = "page";
    public static final String KEY_CURRENCY = "currency";
    public static final String KEY_SALARY = "salary";

    private Preference<String> keywords;
    private Preference<String> areaID;
    private Preference<String> areaName;
    private Preference<Integer> page;
    private Preference<String> currency;
    private Preference<String> salary;

    private boolean cached;
    private boolean loadMore;

    public VacancyFilter(RxSharedPreferences preferences) {
        keywords = preferences.getString(KEY_KEYWORDS, "");
        areaID = preferences.getString(KEY_AREA_ID, "");
        areaName = preferences.getString(KEY_AREA_NAME, "");
        page = preferences.getInteger(KEY_PAGE, 0);
        currency = preferences.getString(KEY_CURRENCY, "RUR");
        salary = preferences.getString(KEY_SALARY, "");
    }

    public String getKeywords() {
        return keywords.get();
    }

    public void setKeywords(String keywords) {
        this.keywords.set(keywords);
    }

    public String getAreaID() {
        return areaID.get();
    }

    public void setAreaID(String areaID) {
        this.areaID.set(areaID);
    }

    public String getAreaName() {
        return areaName.get();
    }

    public void setAreaName(String areaName) {
        this.areaName.set(areaName);
    }

    public int getPage() {
        return page.get();
    }

    public void setPage(int page) {
        this.page.set(page);
    }

    public boolean isCached() {
        return cached;
    }

    public void setCached(boolean cached) {
        this.cached = cached;
    }

    public boolean isLoadMore() {
        return loadMore;
    }

    public void setLoadMore(boolean loadMore) {
        this.loadMore = loadMore;
    }

    public String getCurrency() {
        return currency.get();
    }

    public void setCurrency(String currency) {
        this.currency.set(currency);
    }

    public String getSalary() {
        return this.salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

    public Map<String, String> toGetParams() {
        Map<String, String> params = new HashMap<>();
        if (keywords.isSet() && !keywords.get().isEmpty()) {
            params.put("text", keywords.get());
        }
        if (areaID.isSet() && !areaID.get().isEmpty()) {
            params.put("area", areaID.get());
        }
        if (salary.isSet() && !salary.get().isEmpty()) {
            params.put("currency", currency.get());
            params.put("salary", salary.get());
        }
        params.put("page", page.get().toString());
        return params;
    }
}
