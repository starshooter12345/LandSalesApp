package com.project.landmanagementcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SelDBHelper extends SQLiteOpenHelper {
    public SelDBHelper(Context context) {
        super(context,"Sellerlogin.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase selDB) {
        selDB.execSQL("create Table Sellers(selusername Text primary key,selpassword Text,selemail Text,selcn Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase selDB, int i, int i1) {
        selDB.execSQL("drop Table if exists Sellers");
    }

    public Boolean insertData(String username, String password, String email, String cn){
        SQLiteDatabase selDB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("selusername",username);
        contentValues.put("selpassword",password);
        contentValues.put("selemail",email);
        contentValues.put("selcn",cn);
        long result = selDB.insert( "Sellers", null, contentValues);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkusername(String username){
        SQLiteDatabase selDB = this.getWritableDatabase();
        Cursor cursor = selDB.rawQuery("select * from Sellers where selusername = ?",new String[] {username});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean checkusernamePassword(String username, String password){
        SQLiteDatabase selDB = this.getWritableDatabase();
        Cursor cursor = selDB.rawQuery("select * from Sellers where selusername = ? and selpassword = ?",new String[] {username,password});
        if (cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }
    }
}
