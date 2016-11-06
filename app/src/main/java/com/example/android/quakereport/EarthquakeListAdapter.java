package com.example.android.quakereport;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.drawable.GradientDrawable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static android.R.attr.format;
import static android.support.v4.content.ContextCompat.getColor;
import static com.example.android.quakereport.R.id.date;
import static com.example.android.quakereport.R.id.time;

/**
 * Created by toddskinner on 11/4/16.
 */

public class EarthquakeListAdapter extends ArrayAdapter<Earthquake> {

    private Context mCon;

    public EarthquakeListAdapter(Activity context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake, parent, false);
        }

        final Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) convertView.findViewById(R.id.magnitude);
        magnitudeTextView.setText(String.valueOf(formatMagnitude(currentEarthquake.getMagnitude())));
        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();
        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

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

    public String formatMagnitude(double mag){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(mag);
    }

    public int getMagnitudeColor(double magnitude){
        switch((int) magnitude) {
            case 0:
            case 1:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
            case 2:
                return ContextCompat.getColor(getContext(), R.color.magnitude2);
            case 3:
                return ContextCompat.getColor(getContext(), R.color.magnitude3);
            case 4:
                return ContextCompat.getColor(getContext(), R.color.magnitude4);
            case 5:
                return ContextCompat.getColor(getContext(), R.color.magnitude5);
            case 6:
                return ContextCompat.getColor(getContext(), R.color.magnitude6);
            case 7:
                return ContextCompat.getColor(getContext(), R.color.magnitude7);
            case 8:
                return ContextCompat.getColor(getContext(), R.color.magnitude8);
            case 9:
                return ContextCompat.getColor(getContext(), R.color.magnitude9);
            case 10:
                return ContextCompat.getColor(getContext(), R.color.magnitude10plus);
            default:
                return ContextCompat.getColor(getContext(), R.color.magnitude1);
        }
    }
}

