package com.example.swapniln.mypocket.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Swapnil.N on 11/23/2016.
 */

public class dbManager  extends SQLiteOpenHelper{
    public static final String DB_NAME ="my_pocket";
    public static final int DB_VERSION =1;

    // Table
    public static final String DB_USER_TABLE ="users";

    //Tbale Fields
    public static final String DB_TABLE_ID ="id";
    public static final String DB_TABLE_NAME ="name";
    public static final String DB_TABLE_MOBILE ="mobile";
    public static final String DB_TABLE_PASSWORD ="password";


    public dbManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE  = "CREATE TABLE "+DB_USER_TABLE+ " ("
                +DB_TABLE_ID+ " integer PRIMARY KEY,"
                +DB_TABLE_NAME+ " TEXT,"
                +DB_TABLE_MOBILE+ " TEXT UNIQUE,"
                +DB_TABLE_PASSWORD+ " TEXT"
                +")";
        db.execSQL(CREATE_USER_TABLE);
    }

    public HashMap login(String username, String password) {
        HashMap user = new HashMap();
        String selectQuery = "SELECT * FROM " + DB_USER_TABLE +
                " WHERE " + DB_TABLE_MOBILE + "='" +username + "' AND "
                + DB_TABLE_PASSWORD +"='"+password+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // Move to first row
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            user.put(DB_TABLE_ID, cursor.getString(0));
            user.put(DB_TABLE_NAME, cursor.getString(1));
            user.put(DB_TABLE_MOBILE, cursor.getString(2));
        }
        cursor.close();
        db.close();
        return user;
    }

    public void register(String name,String mobile,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DB_TABLE_NAME, name);
        values.put(DB_TABLE_PASSWORD, password);
        values.put(DB_TABLE_MOBILE, mobile);
        db.insert(DB_USER_TABLE, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String deleteTable = "DROP TABLE "+DB_USER_TABLE;
        db.execSQL(deleteTable);

    }
}
