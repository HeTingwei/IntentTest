package com.example.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/*
* this activity receive object from FirstActivity ,use Intent and Parcelable
* */
public class SixthActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_layout);
        textView = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        User user = bundle.getParcelable("user");
        String password = user.getUser2().getPassword();
        textView.setText("Name:"+user.getName()+"\n Age:"+user.getAge()+"\n password:"+password);
    }
}
