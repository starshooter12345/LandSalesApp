package com.project.landmanagementcode;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class buyerDBhelper extends SQLiteOpenHelper{
    public buyerDBhelper( Context context) {
        super(context,"buyerLogin.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase buyDB) {
       buyDB.execSQL("create Table buyers(buyname Text ,buyemail Text primary key, buypassword Text, buyphonenumber Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase buyDB, int oldVersion, int newVersion) {

        buyDB.execSQL("drop Table if exists buyers");
    }

    public  Boolean insertData(String name, String email, String password, String phonenumber){
        SQLiteDatabase buyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("buyname",name);
        contentValues.put("buyemail",email);
        contentValues.put("buypassword", password);
        contentValues.put("buyphonenumber",phonenumber);
        long result = buyDB.insert("buyers",null,contentValues);

        if(result ==-1){
            return  false;
        }
        else{
            return true;
        }

    }

        public boolean checkbuyemail(String buyemail)
        {

            SQLiteDatabase buyDB = this.getWritableDatabase();
            Cursor cursor = buyDB.rawQuery("select * from buyers where buyemail = ?", new String[]{buyemail});
            if (cursor.getCount() > 0)
            {

                return true;

            } else
                {
                return false;
                }
        }

        public boolean checkbuyemailpassword(String buyemail , String buypassword) {
        SQLiteDatabase buyDB = this.getWritableDatabase();
        Cursor cursor = buyDB.rawQuery("select * from buyers where buyemail= ? and buypassword = ?",new String[] {buyemail,buypassword});
        if(cursor.getCount() > 0){
            return true;
        }
        else{
            return false;
        }



    }

}
