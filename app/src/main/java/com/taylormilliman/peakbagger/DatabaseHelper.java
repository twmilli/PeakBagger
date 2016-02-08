package com.taylormilliman.peakbagger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by twmilli on 1/16/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "mountains";
    public static final String TABLE_NAME = "nhfooter";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "Height";
    public static final String COL_4 = "Latitudes";
    public static final String COL_5 = "Longitudes";
    public static final String COL_6 = "Range";
    public static final String COL_7 = "Prom";
    public static final String COL_8 = "Climbed";

    //public static final int NUMMOUNTAIN = 48;


    String [] mountainNames;
    int[] mountainHeights;
    double [] latitudes;
    double [] longitudes;
    String [] range;
    int[] prominance;

    String DB_PATH;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, HEIGHT INTEGER, " +
                COL_4 + " DOUBLE, " + COL_5 + " DOUBLE, " + COL_6 + " TEXT, " + COL_7 + " INTEGER, " + COL_8 + " BOOLEAN DEFAULT FALSE) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addData(String name, int height, Double lat, Double lng, String range, int prom){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, height);
        contentValues.put(COL_4, lat);
        contentValues.put(COL_5, lng);
        contentValues.put(COL_6, range);
        contentValues.put(COL_7, prom);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1){
            Log.i("result", "FAILED");
        }else{
            Log.i("result", "SUCCESS");
        }


    }
    public void addInfo(){
        mountainNames = new String[]{"Washington",
                "Adams",
                "Jefferson",
                "Monroe",
                "Madison",
                "Lafayette",
                "Lincoln",
                "South Twin",
                "Carter Dome",
                "Moosilauke",
                "Eisenhower",
                "North Twin",
                "Carrigain",
                "Bond",
                "Middle Carter",
                "West Bond",
                "Garfield",
                "Liberty",
                "South Carter",
                "Wildcat, A peak",
                "Hancock",
                "South Kinsman",
                "Field",
                "Osceola",
                "Flume",
                "South Hancock",
                "Pierce",
                "North Kinsman",
                "Willey",
                "Bondcliff",
                "Zealand",
                "North Tripyramid",
                "Cabot",
                "East Osceola",
                "Middle Tripyramid",
                "Cannon",
                "Hale",
                "Jackson",
                "Tom",
                "Wildcat, D Peak",
                "Moriah",
                "Passaconaway",
                "Owl's Head",
                "Galehead",
                "Whiteface",
                "Waumbek",
                "Isolation",
                "Tecumseh" };

        mountainHeights = new int[]{6288,
                5774,
                5712,
                5384,
                5367,
                5260,
                5089,
                4902,
                4832,
                4802,
                4780,
                4761,
                4700,
                4698,
                4610,
                4540,
                4500,
                4459,
                4430,
                4422,
                4420,
                4358,
                4340,
                4340,
                4328,
                4319,
                4310,
                4293,
                4285,
                4265,
                4260,
                4180,
                4170,
                4156,
                4140,
                4100,
                4054,
                4052,
                4051,
                4050,
                4049,
                4043,
                4025,
                4024,
                4020,
                4006,
                4004,
                4003,
        };
        latitudes = new double[]{44.270464,
                44.320675,
                44.304185,
                44.255050,
                44.328843,
                44.160730,
                44.148832,
                44.187702,
                44.267352,
                44.024326,
                44.240526,
                44.202594,
                44.093567,
                44.153045,
                44.303054,
                44.154734,
                44.187219,
                44.115781,
                44.289823,
                44.259231,
                44.083370,
                44.122965,
                44.196195,
                44.001614,
                44.108779,
                44.073219,
                44.226755,
                44.133370,
                44.183428,
                44.140653,
                44.179740,
                43.973254,
                44.505984,
                44.006235,
                43.964662,
                44.156776,
                44.221711,
                44.203202,
                44.210563,
                44.249433,
                44.340522,
                43.954734,
                44.144081,
                44.185020,
                43.936643,
                44.432661,
                44.214706,
                43.966479
        };
        longitudes = new double[]{-71.303444,
                -71.291695,
                -71.316750,
                -71.321420,
                -71.276820,
                -71.644560,
                -71.644677,
                -71.554604,
                -71.179195,
                -71.830965,
                -71.350307,
                -71.558053,
                -71.446865,
                -71.531225,
                -71.167757,
                -71.543514,
                -71.610836,
                -71.642142,
                -71.176483,
                -71.201739,
                -71.493429,
                -71.736553,
                -71.433428,
                -71.535615,
                -71.627914,
                -71.487149,
                -71.365783,
                -71.736915,
                -71.421129,
                -71.540616,
                -71.521355,
                -71.442878,
                -71.414423,
                -71.520622,
                -71.440101,
                -71.698626,
                -71.512254,
                -71.375523,
                -71.446184,
                -71.223766,
                -71.131776,
                -71.380821,
                -71.605039,
                -71.573501,
                -71.407716,
                -71.417564,
                -71.309318,
                -71.556689

        };
        range = new String[]{"Presidential",
                "Northern Peaks",
                "Northern Peaks",
                "Southern Peaks",
                "Northern Peaks",
                "Franconia Range",
                "Franconia Range",
                "Twin Range",
                "Carter Range",
                "Moosilauke Area",
                "Southern Peaks",
                "Twin Range",
                "Pemigewasset Ranges",
                "Twin Range",
                "Carter Range",
                "Twin Range",
                "Franconia Range",
                "Franconia Range",
                "Carter Range",
                "Carter Range",
                "Pemigewasset Ranges",
                "Kinsman Range",
                "Willey Range",
                "Osceola-Tecumseh",
                "Franconia Range",
                "Pemigewasset Ranges",
                "Southern Peaks",
                "Kinsman Range",
                "Willey Range",
                "Twin Range",
                "Twin Range",
                "Sandwich Range",
                "Pilot Range",
                "Osceola-Tecumseh",
                "Sandwich Range",
                "Kinsman Range",
                "Twin Range",
                "Southern Peaks",
                "Willey Range",
                "Carter Range",
                "Carter Range",
                "Sandwich Range",
                "Franconia Range",
                "Twin Range",
                "Central Sandwich Range",
                "Pliny Range",
                "Rocky Branch Ridges",
                "Osceola-Tecumseh"

        };
        prominance = new int[]{
                6148,
                861,
                753,
                254,
                466,
                3320,
                169,
                1502,
                2821,
                2932,
                335,
                281,
                2223,
                298,
                700,
                160,
                800,
                379,
                220,
                1034,
                1200,
                2398,
                1681,
                2000,
                408,
                159,
                230,
                253,
                255,
                185,
                200,
                1320,
                2661,
                316,
                240,
                720,
                614,
                332,
                331,
                287,
                922,
                803,
                825,
                264,
                560,
                1289,
                203,
                1723
        };

    }

    public void addAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        if (c.isAfterLast()) {
                addInfo();
                for (int i = 0; i < mountainNames.length; i++) {
                    addData(mountainNames[i], mountainHeights[i], latitudes[i], longitudes[i], range[i], prominance[i]);
                }
        }
    }

    public Cursor setCursor (int position) {
        SQLiteDatabase db = getDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID = " + position, null);
        c.moveToFirst();
        return c;
    }

    public String getInfoString(int position, int colIndex) {
        Cursor c = setCursor(position);
        String info = c.getString(colIndex);
        return info;
    }

    public Double getInfoDouble(int position, int colIndex) {
        Cursor c = setCursor(position);
        Double info = c.getDouble(colIndex);
        return info;
    }

    public int getInfoInteger(int position, int colIndex) {
        Cursor c = setCursor(position);
        int info = c.getInt(colIndex);
        return info;
    }

    public SQLiteDatabase getDatabase(){

        SQLiteDatabase db = this.getWritableDatabase();
        if (db == null){
            db = SQLiteDatabase.openDatabase(DB_PATH+DATABASE_NAME , null, SQLiteDatabase.OPEN_READWRITE);
        }
        return db;
    }

    public String getTableName(){
        return TABLE_NAME;
    }

}
