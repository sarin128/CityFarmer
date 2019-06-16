package com.example.yaesl.cityfarmer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainDBHelper extends SQLiteOpenHelper {

    public MainDBHelper(Context context) {
        super(context,"CityFarmer.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Contractor_Data (ID INTEGER PRIMARY KEY AUTOINCREMENT , Name TEXT , Upload TEXT )");

        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '주말농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,금 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,수 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '화,목 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,화 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '주말농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,금 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,수 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '화,목 농장', '2018-12-23')");
        db.execSQL("INSERT INTO Contractor_Data VALUES (null, '월,화 농장', '2018-12-23')");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
