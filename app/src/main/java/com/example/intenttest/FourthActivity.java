package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FourthActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fourth_layout);
		Intent intent = getIntent();
		String text = intent.getStringExtra("name2");
		Toast.makeText(getBaseContext(), text, Toast.LENGTH_SHORT).show();
	}

}
