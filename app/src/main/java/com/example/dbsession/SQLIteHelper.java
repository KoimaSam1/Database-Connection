package com.example.dbsession;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SQLIteHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public SQLIteHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(Name TEXT, Email TEXT Primary Key,Phone TEXT, Password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
    }
    public Boolean insertData(String Name, String Email,String Phone, String Password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Name",Name);
        contentValues.put("Email",Email);
        contentValues.put("Phone",Phone);
        contentValues.put("Password",Password);
        long result = myDB.insert("users",null,contentValues);
        if (result==-1) return false;
        else
            return true;
    }
    public Boolean checkEmail(String Email){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor  cursor = myDB.rawQuery("Select * from users where Email = ?",new String[] {Email});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
    }
    public Boolean checkEmailPassword(String Email, String Password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        Cursor  cursor = myDB.rawQuery("Select * from users where Email = ? and Password = ?",new String[] {Email,Password});
        if (cursor.getCount() > 0 )
            return true;
        else
            return false;
    }
}
