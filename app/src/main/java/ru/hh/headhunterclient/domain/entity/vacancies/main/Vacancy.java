package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.hh.headhunterclient.domain.entity.base.IdNameRealm;
import ru.hh.headhunterclient.domain.entity.vacancies.address.VacancyAddress;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyArea;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyEmployer;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyRelations;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancySalary;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancySnippet;

public class Vacancy extends RealmObject {

    public static final String SALARY = "salary";
    public static final String SNIPPET = "snippet";
    public static final String ARCHIVED = "archived";
    public static final String PREMIUM = "premium";
    public static final String NAME = "name";
    public static final String AREA = "area";
    public static final String URL = "url";
    public static final String CREATED_AT = "created_at";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String APPLY_ALTERNATE_URL = "apply_alternate_url";
    public static final String RELATIONS = "relations";
    public static final String EMPLOYER = "employer";
    public static final String RESPONSE_LETTER_REQUIRED = "response_letter_required";
    public static final String PUBLISHED_AT = "published_at";
    public static final String TYPE = "type";
    public static final String ID = "id";
    public static final String ADDRESS = "address";

    @PrimaryKey
    @SerializedName(ID)
    private String id;

    @SerializedName(SALARY)
    private VacancySalary salary;

    @SerializedName(SNIPPET)
    private VacancySnippet snippet;

    @SerializedName(ARCHIVED)
    private Boolean archived;

    @SerializedName(PREMIUM)
    private Boolean premium;

    @SerializedName(NAME)
    private String name;

    @SerializedName(AREA)
    private VacancyArea area;

    @SerializedName(URL)
    private String url;

    @SerializedName(CREATED_AT)
    private String createdAt;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(APPLY_ALTERNATE_URL)
    private String applyAlternateUrl;

    @SerializedName(RELATIONS)
    private RealmList<VacancyRelations> relations;

    @SerializedName(EMPLOYER)
    private VacancyEmployer employer;

    @SerializedName(RESPONSE_LETTER_REQUIRED)
    private Boolean responseLetterRequired;

    @SerializedName(PUBLISHED_AT)
    private String published_at;

    @SerializedName(TYPE)
    private IdNameRealm type;

    @SerializedName(ADDRESS)
    private VacancyAddress address;

    public Vacancy() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VacancySalary getSalary() {
        return salary;
    }

    public void setSalary(VacancySalary salary) {
        this.salary = salary;
    }

    public VacancySnippet getSnippet() {
        return snippet;
    }

    public void setSnippet(VacancySnippet snippet) {
        this.snippet = snippet;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VacancyArea getArea() {
        return area;
    }

    public void setArea(VacancyArea area) {
        this.area = area;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getAlternateUrl() {
        return alternateUrl;
    }

    public void setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
    }

    public String getApplyAlternateUrl() {
        return applyAlternateUrl;
    }

    public void setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
    }

    public RealmList<VacancyRelations> getRelations() {
        return relations;
    }

    public void setRelations(RealmList<VacancyRelations> relations) {
        this.relations = relations;
    }

    public VacancyEmployer getEmployer() {
        return employer;
    }

    public void setEmployer(VacancyEmployer employer) {
        this.employer = employer;
    }

    public Boolean getResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(Boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public IdNameRealm getType() {
        return type;
    }

    public void setType(IdNameRealm type) {
        this.type = type;
    }

    public VacancyAddress getAddress() {
        return address;
    }

    public void setAddress(VacancyAddress address) {
        this.address = address;
    }
}

