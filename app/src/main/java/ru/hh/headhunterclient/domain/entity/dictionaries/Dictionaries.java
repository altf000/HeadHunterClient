package ru.hh.headhunterclient.domain.entity.dictionaries;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import ru.hh.headhunterclient.domain.entity.base.IdNameRealm;

public class Dictionaries extends RealmObject {

    public static final String EMPLOYER_ACTIVE_VACANCIES_ORDER = "employer_active_vacancies_order";
    public static final String BUSINESS_TRIP_READINESS = "business_trip_readiness";
    public static final String VACANCY_SEARCH_FIELDS = "vacancy_search_fields";
    public static final String RESUME_SEARCH_LABEL = "resume_search_label";
    public static final String CURRENCY = "currency";
    public static final String TRAVEL_TIME = "travel_time";
    public static final String EDUCATION_LEVEL = "education_level";
    public static final String PREFERRED_CONTACT_TYPE = "preferred_contact_type";
    public static final String EMPLOYMENT = "employment";
    public static final String VACANCY_NOT_PROLONGED_REASON = "vacancy_not_prolonged_reason";
    public static final String VACANCY_LABEL = "vacancy_label";
    public static final String RESUME_ACCESS_TYPE = "resume_access_type";
    public static final String NEGOTIATIONS_STATE = "negotiations_state";
    public static final String APPLICANT_COMMENT_ACCESS_TYPE = "applicant_comment_access_type";
    public static final String LANGUAGE_LEVEL = "language_level";
    public static final String RESUME_CONTACTS_SITE_TYPE = "resume_contacts_site_type";
    public static final String VACANCY_SEARCH_ORDER = "vacancy_search_order";
    public static final String EMPLOYER_HIDDEN_VACANCIES_ORDER = "employer_hidden_vacancies_order";
    public static final String RESUME_SEARCH_ORDER = "resume_search_order";
    public static final String VACANCY_RELATION = "vacancy_relation";
    public static final String SCHEDULE = "schedule";
    public static final String RESUME_SEARCH_LOGIC = "resume_search_logic";
    public static final String NEGOTIATIONS_ORDER = "negotiations_order";
    public static final String RESUME_SEARCH_FIELDS = "resume_search_fields";
    public static final String VACANCY_SITE = "vacancy_site";
    public static final String RESUME_MODERATION_NOTE = "resume_moderation_note";
    public static final String EMPLOYER_ARCHIVED_VACANCIES_ORDER = "employer_archived_vacancies_order";
    public static final String VACANCY_CLUSTER = "vacancy_cluster";
    public static final String RELOCATION_TYPE = "relocation_type";
    public static final String MESSAGING_STATUS = "messaging_status";
    public static final String NEGOTIATIONS_PARTICIPANT_TYPE = "negotiations_participant_type";
    public static final String EMPLOYER_TYPE = "employer_type";
    public static final String GENDER = "gender";
    public static final String VACANCY_BILLING_TYPE = "vacancy_billing_type";
    public static final String EXPERIENCE = "experience";
    public static final String APPLICANT_COMMENTS_ORDER = "applicant_comments_order";
    public static final String EMPLOYER_RELATION = "employer_relation";
    public static final String RESUME_SEARCH_RELOCATION = "resume_search_relocation";
    public static final String VACANCY_TYPE = "vacancy_type";
    public static final String RESUME_STATUS = "resume_status";
    public static final String RESUME_SEARCH_EXPERIENCE_PERIOD = "resume_search_experience_period";

    @SerializedName("employer_active_vacancies_order")
    private RealmList<IdNameRealm> employer_active_vacancies_order;

    @SerializedName("business_trip_readiness")
    private RealmList<IdNameRealm> business_trip_readiness;

    @SerializedName("vacancy_search_fields")
    private RealmList<IdNameRealm> vacancy_search_fields;

    @SerializedName("resume_search_label")
    private RealmList<IdNameRealm> resume_search_label;

    @SerializedName("currency")
    private RealmList<Currency> currency;

    @SerializedName("travel_time")
    private RealmList<IdNameRealm> travel_time;

    @SerializedName("education_level")
    private RealmList<IdNameRealm> education_level;

    @SerializedName("preferred_contact_type")
    private RealmList<IdNameRealm> preferred_contact_type;

    @SerializedName("employment")
    private RealmList<IdNameRealm> employment;

    @SerializedName("vacancy_not_prolonged_reason")
    private RealmList<IdNameRealm> vacancy_not_prolonged_reason;

    @SerializedName("vacancy_label")
    private RealmList<IdNameRealm> vacancy_label;

    @SerializedName("resume_access_type")
    private RealmList<IdNameRealm> resume_access_type;

    @SerializedName("negotiations_state")
    private RealmList<IdNameRealm> negotiations_state;

    @SerializedName("applicant_comment_access_type")
    private RealmList<IdNameRealm> applicant_comment_access_type;

    @SerializedName("language_level")
    private RealmList<IdNameRealm> language_level;

    @SerializedName("resume_contacts_site_type")
    private RealmList<IdNameRealm> resume_contacts_site_type;

    @SerializedName("vacancy_search_order")
    private RealmList<IdNameRealm> vacancy_search_order;

    @SerializedName("employer_hidden_vacancies_order")
    private RealmList<IdNameRealm> employer_hidden_vacancies_order;

    @SerializedName("resume_search_order")
    private RealmList<IdNameRealm> resume_search_order;

    @SerializedName("vacancy_relation")
    private RealmList<IdNameRealm> vacancy_relation;

    @SerializedName("schedule")
    private RealmList<IdNameRealm> schedule;

    @SerializedName("resume_search_logic")
    private RealmList<IdNameRealm> resume_search_logic;

    @SerializedName("negotiations_order")
    private RealmList<IdNameRealm> negotiations_order;

    @SerializedName("resume_search_fields")
    private RealmList<IdNameRealm> resume_search_fields;

    @SerializedName("vacancy_site")
    private RealmList<IdNameRealm> vacancy_site;

    @SerializedName("resume_moderation_note")
    private RealmList<IdNameRealm> resume_moderation_note;

    @SerializedName("employer_archived_vacancies_order")
    private RealmList<IdNameRealm> employer_archived_vacancies_order;

    @SerializedName("vacancy_cluster")
    private RealmList<IdNameRealm> vacancy_cluster;

    @SerializedName("relocation_type")
    private RealmList<IdNameRealm> relocation_type;

    @SerializedName("messaging_status")
    private RealmList<IdNameRealm> messaging_status;

    @SerializedName("negotiations_participant_type")
    private RealmList<IdNameRealm> negotiations_participant_type;

    @SerializedName("employer_type")
    private RealmList<IdNameRealm> employer_type;

    @SerializedName("gender")
    private RealmList<IdNameRealm> gender;

    @SerializedName("vacancy_billing_type")
    private RealmList<IdNameRealm> vacancy_billing_type;

    @SerializedName("experience")
    private RealmList<IdNameRealm> experience;

    @SerializedName("applicant_comments_order")
    private RealmList<IdNameRealm> applicant_comments_order;

    @SerializedName("employer_relation")
    private RealmList<IdNameRealm> employer_relation;

    @SerializedName("resume_search_relocation")
    private RealmList<IdNameRealm> resume_search_relocation;

    @SerializedName("vacancy_type")
    private RealmList<IdNameRealm> vacancy_type;

    @SerializedName("resume_status")
    private RealmList<IdNameRealm> resume_status;

    @SerializedName("resume_search_experience_period")
    private RealmList<IdNameRealm> resume_search_experience_period;

    public Dictionaries() {
    }
}

