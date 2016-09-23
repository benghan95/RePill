package com.example.bhav.repill;

/**
 * Created by BHAV on 23/09/2016.
 */

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.bluetooth.*;
import android.view.*;
import android.widget.*;

public class SingBroadcastReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction(); //may need to chain this to a recognizing function
        if (BluetoothDevice.ACTION_FOUND.equals(action)){
            // Get the BluetoothDevice object from the Intent
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            // Add the name and address to an array adapter to show in a Toast
            String derp = device.getName() + " - " + device.getAddress();
            Toast.makeText(context, derp, Toast.LENGTH_LONG);
        }
    }
}
