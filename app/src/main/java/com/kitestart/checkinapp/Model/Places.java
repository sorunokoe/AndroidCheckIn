package com.kitestart.checkinapp.Model;

import java.util.ArrayList;

public class Places {

    public static ArrayList<Places> allPlaces = new ArrayList();


    private Double lontitude;
    private Double latitude;
    private String name;
    private String time;

    public Places(Double lontitude, Double latitude, String name, String time){
        this.lontitude = lontitude;
        this.latitude = latitude;
        this.name = name;
        this.time = time;
    }


    public Double getLontitude() {
        return lontitude;
    }

    public void setLontitude(Double lontitude) {
        this.lontitude = lontitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
