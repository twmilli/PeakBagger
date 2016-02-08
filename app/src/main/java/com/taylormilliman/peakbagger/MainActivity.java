package com.taylormilliman.peakbagger;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import android.database.SQLException;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> mountainList;
    ArrayAdapter adapter;
    ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myListView = (ListView) findViewById(R.id.listView);

        setUpListView();
        DatabaseHelper dbHelper = TitleActivity.dbHelper;
        Log.i("test", String.valueOf(dbHelper));
        SQLiteDatabase myDB = dbHelper.getDatabase();

        Cursor c = myDB.rawQuery("SELECT * FROM " + dbHelper.getTableName(), null);


        c.moveToFirst();
        c.moveToPrevious();
        int nameIndex = c.getColumnIndex(dbHelper.COL_2);
        Log.i("test", String.valueOf(nameIndex));
        int heightIndex = 2;
        //Log.i("test", String.valueOf(heightIndex));

        while(c.moveToNext()) {
            String mountainName = c.getString(nameIndex);
            int mountainHeight = c.getInt(heightIndex);
            mountainList.add(mountainName
            + "        " + String.valueOf(mountainHeight));

        }



    }
    public void setUpListView(){
        mountainList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, R.layout.custom_text_view, mountainList);
        adapter.notifyDataSetChanged();
        myListView.setAdapter(adapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), MountainActivity.class);
                position = position + 1;
                i.putExtra("position", position);
                startActivity(i);
            }
        });

    }


}

