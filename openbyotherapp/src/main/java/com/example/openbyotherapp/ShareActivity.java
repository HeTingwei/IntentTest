package com.example.openbyotherapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by HeTingwei on 2017/11/7.
 * 这个界面是准备由其他应用的Intent启动的，并且会处理Intent
 */

public class ShareActivity extends AppCompatActivity {
    private static final String TAG = "ShareActivity";
    String result="";
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_layout);
        tv = (TextView) findViewById(R.id.tv);

        // Get the intent that started this activity
        Intent intent = getIntent();
        Uri data = intent.getData();

        // Figure out what to do based on the intent type
        if(intent.getType()!=null)
        if (intent.getType().indexOf("image/") != -1) {
            // Handle intents with image data ...
            Log.d(TAG, "onCreate: img");
            result += "intent type is image";
        } else if (intent.getType().equals("text/plain")) {
            // Handle intents with text ...
            result+="intent type is text";
        }
        result += "\n The data from IntentTest:";
        result+=intent.getStringExtra("data");
        tv.setText(result);
    }
}
