package com.project.landmanagementcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class rentDBhelper extends SQLiteOpenHelper{

    private String rtitle;
    private String rarea;
    private String rental;
    private String rdes;
    private String rseller;

    public rentDBhelper(@Nullable Context context){
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
    public long insertInfo(String rtitle, String rarea, String rental, String rdes, String rseller, String image,String addTimeStamp, String updateTimeStamp) {
        this.rtitle = rtitle;
        this.rarea = rarea;
        this.rental = rental;
        this.rdes = rdes;
        this.rseller = rseller;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.C_RTITLE,rtitle);
        values.put(Constants.C_RAREA,rarea);
        values.put(Constants.C_RENTAL,rental);
        values.put(Constants.C_RDES,rdes);
        values.put(Constants.C_RSELLER,rseller);
        values.put(Constants.C_IMAGE,image);
        values.put(Constants.C_ADD_TIMESTAMP,addTimeStamp);
        values.put(Constants.C_UPDATE_TIMESTAMP,updateTimeStamp);




        long id=db.insert(Constants.TABLE_NAME,null,values);
        db.close();
        return id;

    }

    //update info function
    public void updateInfo(String id,String image,String addTimeStamp, String updateTimeStamp) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.C_RSELLER,rseller);
        values.put(Constants.C_RTITLE,rtitle);
        values.put(Constants.C_RENTAL,rental);
        values.put(Constants.C_RDES,rdes);
        values.put(Constants.C_RAREA,rarea);
        values.put(Constants.C_IMAGE,image);
        values.put(Constants.C_ADD_TIMESTAMP,addTimeStamp);
        values.put(Constants.C_UPDATE_TIMESTAMP,updateTimeStamp);




        db.update(Constants.TABLE_NAME,values,Constants.C_ID + " = ?", new String[]{id});
        db.close();
    }


    //delete information
    public void deleteInfo(String id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.TABLE_NAME,Constants.C_ID + " = ? ",new String[]{id});
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
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_RTITLE)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_RAREA)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_RENTAL)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_RDES)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_RSELLER)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_ADD_TIMESTAMP)),
                        ""+cursor.getString(cursor.getColumnIndex(Constants.C_UPDATE_TIMESTAMP))
                );
                arrayList.add(model);
            }while(cursor.moveToNext());
        }
        db.close();
        return arrayList;
    }




    public void updateInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
    }

    public void updateInfo(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8) {
    }

}
