package com.example.android.quakereport;

import android.app.Activity;
import android.app.LauncherActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

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
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));

        TextView locationTextView = (TextView) convertView.findViewById(R.id.location);
        locationTextView.setText(currentEarthquake.getLocation());

        TextView dateTextView = (TextView) convertView.findViewById(R.id.date);
        dateTextView.setText(currentEarthquake.getDate());

        return convertView;
    }
}
