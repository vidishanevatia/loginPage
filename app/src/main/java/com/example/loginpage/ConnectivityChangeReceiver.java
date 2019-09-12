package com.example.loginpage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Telephony;
import android.util.Log;
import android.widget.Toast;

public class ConnectivityChangeReceiver extends BroadcastReceiver {



    @Override
        public void onReceive(final Context context, final Intent intent) {

            String status = NetworkUtil.getConnectivityStatusString(context);
           Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        FragmentDrawerLayout.sendmessage();
        }
}
