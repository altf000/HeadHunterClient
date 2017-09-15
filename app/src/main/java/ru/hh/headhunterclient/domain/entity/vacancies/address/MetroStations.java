package ru.hh.headhunterclient.domain.entity.vacancies.address;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class MetroStations extends RealmObject {

    public static final String LINE_NAME = "line_name";
    public static final String STATION_ID = "station_id";
    public static final String LINE_ID = "line_id";
    public static final String LAT = "lat";
    public static final String STATION_NAME = "station_name";
    public static final String LNG = "lng";

    @SerializedName(LINE_NAME)
    private String lineName;

    @SerializedName(STATION_ID)
    private String stationID;

    @SerializedName(LINE_ID)
    private String lineID;

    @SerializedName(LAT)
    private Float lat;

    @SerializedName(STATION_NAME)
    private String stationName;

    @SerializedName(LNG)
    private Float lng;

    public MetroStations() {
    }

    public String getLineName() {
        return this.lineName;
    }

    public MetroStations setLineName(String lineName) {
        this.lineName = lineName;
        return this;
    }

    public String getStationID() {
        return this.stationID;
    }

    public MetroStations setStationID(String stationID) {
        this.stationID = stationID;
        return this;
    }

    public String getLineID() {
        return this.lineID;
    }

    public MetroStations setLineID(String lineID) {
        this.lineID = lineID;
        return this;
    }

    public float getLat() {
        return this.lat;
    }

    public MetroStations setLat(float lat) {
        this.lat = lat;
        return this;
    }

    public String getStationName() {
        return this.stationName;
    }

    public MetroStations setStationN(String stationName) {
        this.stationName = stationName;
        return this;
    }

    public Float getLng() {
        return this.lng;
    }

    public MetroStations setLng(Float lng) {
        this.lng = lng;
        return this;
    }
}

