package com.project.landmanagementcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper{

    public DatabaseHelper(@Nullable Context context){
        super(context,Constants.DB_NAME,null,Constants.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Constants.TABLE_NAME);
        onCreate(db);

    }
    //insert into function
    public long insertInfo(String landtitle,String extentinperches, String priceperperch, String landaddress,String landdescription, String sellername, String sellerphone, String selleremail,String image,String addTimeStamp, String updateTimeStamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.C_LANDTITLE, landtitle);
        values.put(Constants.C_EXTENTINPERCHES, extentinperches);
        values.put(Constants.C_PRICEPERPERCH, priceperperch);
        values.put(Constants.C_LANDADDRESS, landaddress);
        values.put(Constants.C_LANDDESCRIPTION, landdescription);
        values.put(Constants.C_SELLERNAME, sellername);
        values.put(Constants.C_SELLEREMAIL, selleremail);
        values.put(Constants.C_SELLERPHONE, sellerphone);
        values.put(Constants.C_IMAGE,image);
        values.put(Constants.C_ADD_TIMESTAMP,addTimeStamp);
        values.put(Constants.C_UPDATE_TIMESTAMP,updateTimeStamp);


        long id=db.insert(Constants.TABLE_NAME,null,values);
        db.close();
        return id;

    }

    //update info function
    public void updateInfo(String id,String landtitle,String extentinperches, String priceperperch, String landaddress,String landdescription, String sellername, String sellerphone, String selleremail,String image,String addTimeStamp, String updateTimeStamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.C_LANDTITLE, landtitle);
        values.put(Constants.C_EXTENTINPERCHES, extentinperches);
        values.put(Constants.C_PRICEPERPERCH, priceperperch);
        values.put(Constants.C_LANDADDRESS, landaddress);
        values.put(Constants.C_LANDDESCRIPTION, landdescription);
        values.put(Constants.C_SELLERNAME, sellername);
        values.put(Constants.C_SELLEREMAIL, selleremail);
        values.put(Constants.C_SELLERPHONE, sellerphone);
        values.put(Constants.C_IMAGE,image);
        values.put(Constants.C_ADD_TIMESTAMP,addTimeStamp);
        values.put(Constants.C_UPDATE_TIMESTAMP,updateTimeStamp);


        db.update(Constants.TABLE_NAME,values,Constants.C_ID + " = ?", new String[]{id});
        db.close();
    }

    public ArrayList<Model>getAllData(String orderBy){
        ArrayList<Model> arrayList = new ArrayList<>();
        //query for selecting all info in the database
        String selectQuery = "SELECT * FROM " + Constants.TABLE_NAME + " ORDER BY " + orderBy;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToNext()){
            do{
                Model model = new Model(
                        ""+cursor.getInt(cursor.getColumnIndex(Constants.C_ID)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_IMAGE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_LANDTITLE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_EXTENTINPERCHES)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_PRICEPERPERCH)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_LANDADDRESS)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_LANDDESCRIPTION)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_SELLERNAME)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_SELLERPHONE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_SELLEREMAIL)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADD_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP))
                );
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }
}