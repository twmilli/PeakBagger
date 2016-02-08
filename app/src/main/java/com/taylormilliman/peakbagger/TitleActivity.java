package com.taylormilliman.peakbagger;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class TitleActivity extends Activity {
    static DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
        dbHelper = new DatabaseHelper(this);
        dbHelper.addAllData();


    }

    @Override
    protected void onResume() {
        super.onResume();
        dbHelper = new DatabaseHelper(this);
        dbHelper.addAllData();
    }

    public void onClick(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}


