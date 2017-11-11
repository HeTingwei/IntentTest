package com.example.intenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/*
* this activity is send data to FirstActivity when is finished
*
* */
public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		Intent intent = new Intent();
		intent.putExtra("name", "Hello FirstActivity!");
		setResult(RESULT_OK, intent);
	}

}
