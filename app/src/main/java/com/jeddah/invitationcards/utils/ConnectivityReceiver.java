package com.jeddah.invitationcards.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityReceiver extends BroadcastReceiver {
    static final  boolean BOOLEAN = false;
    public static ConnectivityReceiverListener connectivityReceiverListener;

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean z);
    }

    public void onReceive(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        ConnectivityReceiverListener connectivityReceiverListener2 = connectivityReceiverListener;
        if (connectivityReceiverListener2 != null) {
            connectivityReceiverListener2.onNetworkConnectionChanged(z);
        }
    }

    public static boolean isConnected() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) Template.getInstance().getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
