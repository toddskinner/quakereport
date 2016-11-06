package com.example.android.quakereport;

import android.app.Activity;
import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.format;
import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.time;

/**
 * Created by toddskinner on 11/4/16.
 */

public class EarthquakeListAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeListAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) convertView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(currentEarthquake.getMagnitude());
        magnitudeTextView.setText(String.valueOf(output));

        TextView locationOffsetTextView = (TextView) convertView.findViewById(R.id.locationOffset);
        String locationOffset = getLocationOffset(currentEarthquake.getLocation());
        locationOffsetTextView.setText(locationOffset);

        TextView primaryLocationTextView = (TextView) convertView.findViewById(R.id.primaryLocation);
        String primaryLocation = getPrimaryLocation(currentEarthquake.getLocation());
        primaryLocationTextView.setText(primaryLocation);

        Date dateObject = new Date(currentEarthquake.getDate());
        TextView dateTextView = (TextView) convertView.findViewById(date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView) convertView.findViewById(time);
        String formattedTime = formatTime(dateObject);
        timeTextView.setText(formattedTime);

        return convertView;
    }

    public String formatDate(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(dateObject);
    }

    public String formatTime(Date dateObject){
        SimpleDateFormat dateFormatter = new SimpleDateFormat("h:mm a");
        return dateFormatter.format(dateObject);
    }

    public String getLocationOffset(String location){
        if(location.contains("km")){
            return location.substring(0, location.lastIndexOf("f") + 1);
        } else {
            return "Near the";
        }
    }

    public String getPrimaryLocation(String location){
        if(location.contains("km")){
            return location.substring(location.lastIndexOf("f") + 1, location.length());
        } else {
            return location;
        }
    }
}

