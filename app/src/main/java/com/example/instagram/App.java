package com.example.instagram;

import android.app.Application;

import com.parse.Parse;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.applicationId))
                // if defined
                .clientKey(getString(R.string.clientKey))
                .server(getString(R.string.serverUrl))
                .build()
        );
    }

}

