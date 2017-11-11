package com.example.intenttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcast extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String str = intent.getStringExtra("data");
		Toast.makeText(context, "It gets the broadcast:\n" + str,
				Toast.LENGTH_SHORT).show();
	}

}
