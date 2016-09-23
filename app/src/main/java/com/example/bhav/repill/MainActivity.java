package com.example.bhav.repill;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.*;
import android.bluetooth.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private TextView tvLog;
    private final static int REQUEST_ENABLE_BT = 6;
    private String[] items;
    private BluetoothAdapter mBluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLog = (TextView) findViewById(R.id.tv2);
        registerReceiver(mReceiver, new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            int state = intent.getIntExtra(BluetoothDevice.EXTRA_BOND_STATE,
                    BluetoothDevice.ERROR);

            if (state == BluetoothDevice.BOND_BONDED) {
                attachText("Device " + device + " PAIRED");
            } else if (state == BluetoothDevice.BOND_BONDING) {
                attachText("Device " + device + " pairing is in process...");
            } else if (state == BluetoothDevice.BOND_NONE) {
                attachText("Device " + device + " is unpaired");
            } else {
                attachText("Device " + device + " is in undefined state");
            }
        }
    };

    private void attachText(String text) {
        String currentText = tvLog.getText() == null ? "" : tvLog.getText().toString();
        tvLog.setText(currentText + "\n" + text);
    }

    private void OnClickBtn_AddBTDevice(View view){
        tvLog.setText("Hello");
    }
//
//    protected void OnClickBtn_AddBTDevice(View v){
//        final ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
//
//        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        if (mBluetoothAdapter == null) {
//            // Testing
//        }
//
//        if (!mBluetoothAdapter.isEnabled()) {
//            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
//            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
//        }
//
//        if (mBluetoothAdapter.isEnabled()){
//            if (mBluetoothAdapter.isDiscovering()) {
//                mBluetoothAdapter.cancelDiscovery();
//            }
//            mBluetoothAdapter.startDiscovery();
//
//            //let's make a broadcast receiver to register our things
//            mReceiver = new SingBroadcastReceiver();
//            IntentFilter iFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
//            this.registerReceiver(mReceiver, iFilter);
//
//            ListView listView = (ListView) findViewById(R.id.lvItems);
//            listView.setAdapter(itemsAdapter);
//            // Register the BroadcastReceiver
//        }
//    }
}
