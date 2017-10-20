package ru.hh.headhunterclient.domain.entity.vacancies.address;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class VacancyAddress extends RealmObject {

    public static final String BUILDING = "building";
    public static final String CITY = "city";
    public static final String METRO_STATIONS = "metro_stations";
    public static final String STREET = "street";
    public static final String LAT = "lat";
    public static final String LNG = "lng";
    public static final String ID = "id";
    public static final String METRO = "metro";

    @SerializedName(BUILDING)
    private String building;

    @SerializedName(CITY)
    private String city;

    @SerializedName(METRO_STATIONS)
    private RealmList<VacancyMetro> metroStations;

    @SerializedName(STREET)
    private String street;

    @SerializedName(LAT)
    private Float lat;

    @SerializedName(LNG)
    private Float lng;

    @SerializedName(ID)
    private String id;

    @SerializedName(METRO)
    private VacancyMetro metro;

    public VacancyAddress() {
    }

    public String getBuilding() {
        return this.building;
    }

    public VacancyAddress setBuilding(String building) {
        this.building = building;
        return this;
    }

    public String getCity() {
        return this.city;
    }

    public VacancyAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public RealmList<VacancyMetro> getMetroStations() {
        return this.metroStations;
    }

    public VacancyAddress setMetroStations(RealmList<VacancyMetro> metroStations) {
        this.metroStations = metroStations;
        return this;
    }

    public String getStreet() {
        return this.street;
    }

    public VacancyAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public float getLat() {
        return this.lat;
    }

    public VacancyAddress setLat(float lat) {
        this.lat = lat;
        return this;
    }

    public Float getLng() {
        return this.lng;
    }

    public VacancyAddress setLng(Float lng) {
        this.lng = lng;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public VacancyAddress setId(String id) {
        this.id = id;
        return this;
    }

    public VacancyMetro getMetro() {
        return this.metro;
    }

    public VacancyAddress setMetro(VacancyMetro metro) {
        this.metro = metro;
        return this;
    }
}

