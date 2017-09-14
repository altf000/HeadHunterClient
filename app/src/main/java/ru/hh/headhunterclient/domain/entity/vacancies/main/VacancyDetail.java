package ru.hh.headhunterclient.domain.entity.vacancies.main;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import ru.hh.headhunterclient.domain.entity.vacancies.address.Address;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Area;
import ru.hh.headhunterclient.domain.entity.vacancies.common.BillingType;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Department;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Employer;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Employment;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Experience;
import ru.hh.headhunterclient.domain.entity.vacancies.common.KeySkills;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Salary;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Schedule;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Specializations;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Test;
import ru.hh.headhunterclient.domain.entity.vacancies.common.Type;
import ru.hh.headhunterclient.domain.entity.vacancies.contacts.Contacts;

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
    private RealmList<KeySkills> keySkills;

    @SerializedName(SCHEDULE)
    private Schedule schedule;

    @SerializedName(ACCEPT_HANDICAPPED)
    private boolean acceptHandicapped;

    @SerializedName(EXPERIENCE)
    private Experience experience;

    @SerializedName(ADDRESS)
    private Address address;

    @SerializedName(ALTERNATE_URL)
    private String alternateUrl;

    @SerializedName(APPLY_ALTERNATE_URL)
    private String applyAlternateUrl;

    @SerializedName(CODE)
    private String code;

    @SerializedName(DEPARTMENT)
    private Department department;

    @SerializedName(EMPLOYMENT)
    private Employment employment;

    @SerializedName(SALARY)
    private Salary salary;

    @SerializedName(ARCHIVED)
    private boolean archived;

    @SerializedName(NAME)
    private String name;

    @SerializedName(AREA)
    private Area area;

    @SerializedName(PUBLISHED_AT)
    private String publishedAt;

    @SerializedName(EMPLOYER)
    private Employer employer;

    @SerializedName(RESPONSE_LETTER_REQUIRED)
    private boolean responseLetterRequired;

    @SerializedName(TYPE)
    private Type type;

    @SerializedName(TEST)
    private Test test;

    @SerializedName(SPECIALIZATIONS)
    private RealmList<Specializations> specializations;

    @SerializedName(CONTACTS)
    private Contacts contacts;

    @SerializedName(BILLING_TYPE)
    private BillingType billingType;

    @SerializedName(ALLOW_MESSAGES)
    private boolean allowMessages;

    @SerializedName(PREMIUM)
    private boolean premium;

    public VacancyDetail() {
    }

    public String getId() {
        return this.id;
    }

    public VacancyDetail setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return this.description;
    }

    public VacancyDetail setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getBrandedDescription() {
        return this.brandedDescription;
    }

    public VacancyDetail setBrandedDescription(String brandedDescription) {
        this.brandedDescription = brandedDescription;
        return this;
    }

    public RealmList<KeySkills> getKeySkills() {
        return this.keySkills;
    }

    public VacancyDetail setKeySkills(RealmList<KeySkills> keySkills) {
        this.keySkills = keySkills;
        return this;
    }

    public Schedule getSchedule() {
        return this.schedule;
    }

    public VacancyDetail setSchedule(Schedule schedule) {
        this.schedule = schedule;
        return this;
    }

    public boolean getAcceptHandicapped() {
        return this.acceptHandicapped;
    }

    public VacancyDetail setAcceptHandicapped(boolean acceptHandicapped) {
        this.acceptHandicapped = acceptHandicapped;
        return this;
    }

    public Experience getExperience() {
        return this.experience;
    }

    public VacancyDetail setExperience(Experience experience) {
        this.experience = experience;
        return this;
    }

    public Address getAddress() {
        return this.address;
    }

    public VacancyDetail setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getAlternateUrl() {
        return this.alternateUrl;
    }

    public VacancyDetail setAlternateUrl(String alternateUrl) {
        this.alternateUrl = alternateUrl;
        return this;
    }

    public String getApplyAlternateUrl() {
        return this.applyAlternateUrl;
    }

    public VacancyDetail setApplyAlternateUrl(String applyAlternateUrl) {
        this.applyAlternateUrl = applyAlternateUrl;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public VacancyDetail setCode(String code) {
        this.code = code;
        return this;
    }

    public Department getDepartment() {
        return this.department;
    }

    public VacancyDetail setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public Employment getEmployment() {
        return this.employment;
    }

    public VacancyDetail setEmployment(Employment employment) {
        this.employment = employment;
        return this;
    }

    public Salary getSalary() {
        return this.salary;
    }

    public VacancyDetail setSalary(Salary salary) {
        this.salary = salary;
        return this;
    }

    public boolean getArchived() {
        return this.archived;
    }

    public VacancyDetail setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public VacancyDetail setName(String name) {
        this.name = name;
        return this;
    }

    public Area getArea() {
        return this.area;
    }

    public VacancyDetail setArea(Area area) {
        this.area = area;
        return this;
    }

    public String getPublishedAt() {
        return this.publishedAt;
    }

    public VacancyDetail setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public Employer getEmployer() {
        return this.employer;
    }

    public VacancyDetail setEmployer(Employer employer) {
        this.employer = employer;
        return this;
    }

    public boolean getResponseLetterRequired() {
        return this.responseLetterRequired;
    }

    public VacancyDetail setResponseLetterRequired(boolean responseLetterRequired) {
        this.responseLetterRequired = responseLetterRequired;
        return this;
    }

    public Type getType() {
        return this.type;
    }

    public VacancyDetail setType(Type type) {
        this.type = type;
        return this;
    }

    public Test getTest() {
        return this.test;
    }

    public VacancyDetail setTest(Test test) {
        this.test = test;
        return this;
    }

    public RealmList<Specializations> getSpecializations() {
        return this.specializations;
    }

    public VacancyDetail setSpecializations(RealmList<Specializations> specializations) {
        this.specializations = specializations;
        return this;
    }

    public Contacts getContacts() {
        return this.contacts;
    }

    public VacancyDetail setContacts(Contacts contacts) {
        this.contacts = contacts;
        return this;
    }

    public BillingType getBillingType() {
        return this.billingType;
    }

    public VacancyDetail setBillingType(BillingType billingType) {
        this.billingType = billingType;
        return this;
    }

    public boolean getAllowMessages() {
        return this.allowMessages;
    }

    public VacancyDetail setAllowMessages(boolean allowMessages) {
        this.allowMessages = allowMessages;
        return this;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public VacancyDetail setPremium(boolean premium) {
        this.premium = premium;
        return this;
    }

}
