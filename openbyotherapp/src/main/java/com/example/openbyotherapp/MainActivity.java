package com.example.openbyotherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/*
*
* 允许其他应用启动您的 Activity
* */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
