package ru.hh.headhunterclient.domain.entity.area;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by neox on 22.09.17.
 */

public class Area extends RealmObject {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String AREAS = "areas";

    @PrimaryKey
    @SerializedName(ID)
    private String id;

    @SerializedName(NAME)
    private String name;

    @SerializedName(AREAS)
    private RealmList<Area> areas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RealmList<Area> getAreas() {
        return areas;
    }

    public void setAreas(RealmList<Area> areas) {
        this.areas = areas;
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", areas=" + areas +
                '}';
    }
}
