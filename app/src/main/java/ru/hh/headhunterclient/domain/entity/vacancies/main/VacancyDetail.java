package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.hh.headhunterclient.domain.entity.base.IdNameRealm;
import ru.hh.headhunterclient.domain.entity.vacancies.address.VacancyAddress;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyArea;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyEmployer;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyKeySkills;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancySalary;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancySpecializations;
import ru.hh.headhunterclient.domain.entity.vacancies.common.VacancyTest;
import ru.hh.headhunterclient.domain.entity.vacancies.contacts.VacancyContacts;

public class VacancyDetail extends RealmObject {

    public static final String ID = "id";
    public static final String DESCRIPTION = "description";
    public static final String BRANDED_DESCRIPTION = "branded_description";
    public static final String KEY_SKILLS = "key_skills";
    public static final String SCHEDULE = "schedule";
    public static final String ACCEPT_HANDICAPPED = "accept_handicapped";
    public static final String EXPERIENCE = "experience";
    public static final String ADDRESS = "address";
    public static final String ALTERNATE_URL = "alternate_url";
    public static final String APPLY_ALTERNATE_URL = "apply_alternate_url";
    public static final String CODE = "code";
    public static final String DEPARTMENT = "department";
    public static final String EMPLOYMENT = "employment";
    public static final String SALARY = "salary";
    public static final String ARCHIVED = "archived";
    public static final String NAME = "name";
    public static final String AREA = "area";
    public static final String PUBLISHED_AT = "published_at";
    public static final String EMPLOYER = "employer";
    public static final String RESPONSE_LETTER_REQUIRED = "response_letter_required";
    public static final String TYPE = "type";
    public static final String TEST = "test";
    public static final String SPECIALIZATIONS = "specializations";
    public static final String CONTACTS = "contacts";
    public static final String BILLING_TYPE = "billing_type";
    public static final String ALLOW_MESSAGES = "allow_messages";
    public static final String PREMIUM = "premium";

    @PrimaryKey
    @SerializedName(ID)
    private String id;

    @SerializedName(DESCRIPTION)
    private String description;

    @SerializedName(BRANDED_DESCRIPTION)
    private String brandedDescription;

    @SerializedName(KEY_SKILLS)
    private RealmList<VacancyKeySkills> keySkills;

    @SerializedName(SCHEDULE)
    private IdNameRealm schedule;

    @SerializedName(ACCEPT_HANDICAPPED)
    private boolean acceptHandicapped;

    @SerializedName(EXPERIENCE)
    private IdNameRealm experience;

    @SerializedName(ADDRESS)
    private VacancyAddress address;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(APPLY_ALTERNATE_URL)
    private String applyAlternateUrl;

    @SerializedName(CODE)
    private String code;

    @SerializedName(DEPARTMENT)
    private IdNameRealm department;

    @SerializedName(EMPLOYMENT)
    private IdNameRealm employment;

    @SerializedName(SALARY)
    private VacancySalary salary;

    @SerializedName(ARCHIVED)
    private boolean archived;

    @SerializedName(NAME)
    private String name;

    @SerializedName(AREA)
    private VacancyArea area;

    @SerializedName(PUBLISHED_AT)
    private String publishedAt;

    @SerializedName(EMPLOYER)
    private VacancyEmployer employer;

    @SerializedName(RESPONSE_LETTER_REQUIRED)
    private boolean responseLetterRequired;

    @SerializedName(TYPE)
    private IdNameRealm type;

    @SerializedName(TEST)
    private VacancyTest test;

    @SerializedName(SPECIALIZATIONS)
    private RealmList<VacancySpecializations> specializations;

    @SerializedName(CONTACTS)
    private VacancyContacts contacts;

    @SerializedName(BILLING_TYPE)
    private IdNameRealm billingType;

    @SerializedName(ALLOW_MESSAGES)
    private boolean allowMessages;

    @SerializedName(PREMIUM)
    private boolean premium;

    public VacancyDetail() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandedDescription() {
        return brandedDescription;
    }

    public void setBrandedDescription(String brandedDescription) {
        this.brandedDescription = brandedDescription;
    }

    public RealmList<VacancyKeySkills> getKeySkills() {
        return keySkills;
    }

    public void setKeySkills(RealmList<VacancyKeySkills> keySkills) {
        this.keySkills = keySkills;
    }

    public IdNameRealm getSchedule() {
        return schedule;
    }

    public void setSchedule(IdNameRealm schedule) {
        this.schedule = schedule;
    }

    public boolean isAcceptHandicapped() {
        return acceptHandicapped;
    }

    public void setAcceptHandicapped(boolean acceptHandicapped) {
        this.acceptHandicapped = acceptHandicapped;
    }

    public IdNameRealm getExperience() {
        return experience;
    }

    public void setExperience(IdNameRealm experience) {
        this.experience = experience;
    }

    public VacancyAddress getAddress() {
        return address;
    }

    public void setAddress(VacancyAddress address) {
        this.address = address;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IdNameRealm getDepartment() {
        return department;
    }

    public void setDepartment(IdNameRealm department) {
        this.department = department;
    }

    public IdNameRealm getEmployment() {
        return employment;
    }

    public void setEmployment(IdNameRealm employment) {
        this.employment = employment;
    }

    public VacancySalary getSalary() {
        return salary;
    }

    public void setSalary(VacancySalary salary) {
        this.salary = salary;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
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

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public VacancyEmployer getEmployer() {
        return employer;
    }

    public void setEmployer(VacancyEmployer employer) {
        this.employer = employer;
    }

    public boolean isResponseLetterRequired() {
        return responseLetterRequired;
    }

    public void setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
    }

    public IdNameRealm getType() {
        return type;
    }

    public void setType(IdNameRealm type) {
        this.type = type;
    }

    public VacancyTest getTest() {
        return test;
    }

    public void setTest(VacancyTest test) {
        this.test = test;
    }

    public RealmList<VacancySpecializations> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(RealmList<VacancySpecializations> specializations) {
        this.specializations = specializations;
    }

    public VacancyContacts getContacts() {
        return contacts;
    }

    public void setContacts(VacancyContacts contacts) {
        this.contacts = contacts;
    }

    public IdNameRealm getBillingType() {
        return billingType;
    }

    public void setBillingType(IdNameRealm billingType) {
        this.billingType = billingType;
    }

    public boolean isAllowMessages() {
        return allowMessages;
    }

    public void setAllowMessages(boolean allowMessages) {
        this.allowMessages = allowMessages;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
