package com.example.android.quakereport;

/**
 * Created by toddskinner on 11/4/16.
 */

public class Earthquake {
    private String mLocation;
    private double mMagnitude;
    private String mDate;

    public Earthquake (double magnitude, String location, String date){
        mLocation = location;
        mDate = date;
        mMagnitude = magnitude;
    }

    public String getLocation(){
        return mLocation;
    }

    public double getMagnitude(){
        return mMagnitude;
    }

    public String getDate(){
        return mDate;
    }
}
