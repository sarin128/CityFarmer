package com.example.yaesl.cityfarmer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Map;
import java.util.TreeMap;


public class DBControll {
    private Context context;
    private MainDBHelper helper;
    Map UserData;


    public DBControll(Context context)
    {
        this.context = context;
        helper = new MainDBHelper(this.context);
    }

    public void InsertData(ContractorData Data)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("INSERT INTO Contractor_Data VALUES (NULL, '" + Data.getName() + "', '"+ Data.getTimeLimit() +"' )");
        helper.close();
    }

    public Map<Integer,ContractorData> SelectData()
    {
        UserData = new TreeMap<Integer, ContractorData>();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Contractor_Data",null);
        while (cursor.moveToNext())
        {
            Integer id = cursor.getInt(0);
            String Name = cursor.getString(1);

            ContractorData data = new ContractorData(id,Name);
            UserData.put(id,data);
        }

        cursor.close();
        helper.close();

        return UserData;
    }

    public void DeleteData(Integer id)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("DELETE FROM Contractor_Data WHERE ID = " + id.intValue() );
        helper.close();
    }
}
