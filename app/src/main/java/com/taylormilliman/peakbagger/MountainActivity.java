package com.taylormilliman.peakbagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MountainActivity extends AppCompatActivity {
    TextView nameText;
    TextView elevationText;
    TextView locationText;
    TextView promText;
    TextView rangeText;

    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mountain);
         dbHelper = TitleActivity.dbHelper;

        Intent i = getIntent();
        int position = i.getIntExtra("position", -1);
        displayText(position);

        setTitle("Peak details");


    }

    public void displayText(int position){
        nameText = (TextView) findViewById(R.id.mountainName);
        elevationText = (TextView) findViewById(R.id.elevationActual);
        locationText = (TextView) findViewById(R.id.locationActual);
        promText = (TextView) findViewById(R.id.promActual);
        rangeText = (TextView) findViewById(R.id.rangeActual);

        String name = dbHelper.getInfoString(position, 1);
        int height = dbHelper.getInfoInteger(position, 2);
        Double lat = dbHelper.getInfoDouble(position, 3);
        Double lng = dbHelper.getInfoDouble(position, 4);
        String range = dbHelper.getInfoString(position, 5);
        int prom = dbHelper.getInfoInteger(position, 6);

        nameText.setText(name);
        elevationText.setText(String.valueOf(height));
        locationText.setText(String.valueOf(lat) + ", " + String.valueOf(lng));
        promText.setText(String.valueOf(prom));
        rangeText.setText(range);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mountain, menu);
        return true;
    }
}
