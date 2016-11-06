package com.example.android.quakereport;

import java.util.Date;
import java.text.SimpleDateFormat;
import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.magnitude;

/**
 * Created by toddskinner on 11/4/16.
 */

public class Earthquake {
    private String mLocation;
    private double mMagnitude;
    private Long mDate;

    public Earthquake (double magnitude, String location, Long date){
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

    public Long getDate(){
        return mDate;
    }
}
