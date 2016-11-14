package com.example.android.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import java.util.List;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.util.Log;

/**
 * Created by toddskinner on 11/10/16.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    private String mUrl;

    /**
     * Constructs a new {@link EarthquakeLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    //we override the onStartLoading() method to call forceLoad() which is a required step to actually trigger the loadInBackground() method to execute.
    @Override
    protected void onStartLoading() {
        //Log.e("onstart","Run onStartLoader");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        //Log.e("onloadbackground","Run onLoadInBackground");
        return QueryUtils.fetchEarthquakeData(mUrl);
    }
}
