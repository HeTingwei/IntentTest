package com.example.intenttest;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class FirstActivity extends Activity {

	String str = "Hello my friends";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.first_layout);
	}

	// Pass the message to the last activity
	public void click2(View v) {
		Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
		intent.putExtra("name", str);
		startActivityForResult(intent, 1);
	}

	// explicit Intent
	public void click3(View v) {
		Intent intent = new Intent(FirstActivity.this, ThirdActivity.class);
		startActivity(intent);
	}

	// implicit Intent,and pass the message to the next activity
	public void click4(View v) {
		Intent intent = new Intent("com.example.tsst19.MY_ACTION");
		intent.addCategory("com.example.tsst19.MY_CATEGORY");
		intent.putExtra("name2", "Hello,forth interface");
		startActivity(intent);
	}

	// open web
	public void webClick(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setData(Uri.parse("http://www.baidu.com"));
		startActivity(intent);
	}

	// Go to the interface to ready to call the phone,
	public void dailClick(View v) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:10086"));
		startActivity(intent);
	}

	// Call directly
	public void callClick(View v) {
		Intent intent = new Intent(Intent.ACTION_CALL);
		intent.setData(Uri.parse("tel:1008611"));
		if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
			ActivityCompat.requestPermissions(FirstActivity.this, new String[]{Manifest.permission.CALL_PHONE,},1);
			return;
		}
		startActivity(intent);
	}

	// broadcast
	public void broadcastClick(View v) {
		Intent intent = new Intent("com.example.tsst19.MY_BROADCAST");
		intent.putExtra("data", "This is a broadcast");
		sendBroadcast(intent);
	}


	public void openOtherAppClick(View view) {
		Intent intent = new Intent("com.example.openbyotherapp.ShareActivity");
        intent.putExtra("data", "Hello openByOtherApp !");
        intent.setDataAndType(Uri.parse("http://www.baidu.com"),"text/plain");
        try {
            startActivity(intent);
        } catch (Exception e) {
        }

	}

	public void objectClick(View view) {
		Intent intent = new Intent(this, SixthActivity.class);
		Bundle bundle = new Bundle();
		bundle.putParcelable("user",new User("name",12,new User2("123456")));
		intent.putExtras(bundle);
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {

			case 1 :
				if (resultCode == RESULT_OK) {
					String str = data.getStringExtra("name");
					toast(str);
				}
				break;
			default :

		}
	}

	public void toast(String str) {
		Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
	}

	private void log(String str) {
		Log.d("log", str);
	}

}
