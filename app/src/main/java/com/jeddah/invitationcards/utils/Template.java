package com.jeddah.invitationcards.utils;

import android.app.Application;

public class Template extends Application {
    private static Template mInstance;

    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static synchronized Template getInstance() {
        Template template;
        synchronized (Template.class) {
            template = mInstance;
        }
        return template;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener connectivityReceiverListener) {
        ConnectivityReceiver.connectivityReceiverListener = connectivityReceiverListener;
    }
}
