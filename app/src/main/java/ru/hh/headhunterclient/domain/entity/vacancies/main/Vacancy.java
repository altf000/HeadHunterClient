package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Area;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Employer;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Relations;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Salary;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Snippet;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Type;
import ru.hh.headhunterclient.domain.entity.vacancies.address.Address;

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
    private String id;
    private Salary salary;
    private Snippet snippet;
    private boolean archived;
    private boolean premium;
    private String name;
    private Area area;
    private String url;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("alternate_url")
    private String alternateUrl;
    @SerializedName("apply_alternate_url")
    private String applyAlternateUrl;
    private RealmList<Relations> relations;
    private Employer employer;
    @SerializedName("response_letter_required")
    private boolean responseLetterRequired;
    @SerializedName("publishedAt")
    private String published_at;
    private Type type;
    private Address address;

    public Vacancy() {
    }

    public Salary getSalary() {
        return this.salary;
    }

    public Vacancy setSalary(Salary salary) {
        this.salary = salary;
        return this;
    }

    public Snippet getSnippet() {
        return this.snippet;
    }

    public Vacancy setSnippet(Snippet snippet) {
        this.snippet = snippet;
        return this;
    }

    public boolean getArchived() {
        return this.archived;
    }

    public Vacancy setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public Vacancy setPremium(boolean premium) {
        this.premium = premium;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Vacancy setName(String name) {
        this.name = name;
        return this;
    }

    public Area getArea() {
        return this.area;
    }

    public Vacancy setArea(Area area) {
        this.area = area;
        return this;
    }

    public String getUrl() {
        return this.url;
    }

    public Vacancy setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public Vacancy setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getAlternateUrl() {
        return this.alternateUrl;
    }

    public Vacancy setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
        return this;
    }

    public String getApplyAlternateUrl() {
        return this.applyAlternateUrl;
    }

    public Vacancy setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
        return this;
    }

    public RealmList<Relations> getRelations() {
        return this.relations;
    }

    public Vacancy setRelations(RealmList<Relations> relations) {
        this.relations = relations;
        return this;
    }

    public Employer getEmployer() {
        return this.employer;
    }

    public Vacancy setEmployer(Employer employer) {
        this.employer = employer;
        return this;
    }

    public boolean getResponseLetterRequired() {
        return this.responseLetterRequired;
    }

    public Vacancy setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
        return this;
    }

    public String getPublished_at() {
        return this.published_at;
    }

    public Vacancy setPublished_at(String published_at) {
        this.published_at = published_at;
        return this;
    }

    public Type getType() {
        return this.type;
    }

    public Vacancy setType(Type type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public Vacancy setId(String id) {
        this.id = id;
        return this;
    }

    public Address getAddress() {
        return this.address;
    }

    public Vacancy setAddress(Address address) {
        this.address = address;
        return this;
    }
}

