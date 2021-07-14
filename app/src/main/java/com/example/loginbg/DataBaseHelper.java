package com.example.loginbg;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "USER_ACCOUNT";
    private static final String TABLE_NAME = "ACCOUNT";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "PASSWORD";
    private static final String COL_4 = "EMAIL";

    public DataBaseHelper( Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(STT INTEGER PRIMARY KEY AUTOINCREMENT,ID VARCHAR , USERNAME VARCHAR , PASSWORD VARCHAR, EMAIL VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }


    public boolean registerUser( String id ,String username , String pass, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_1,id);
        values.put(COL_2,username);
        values.put(COL_3,pass);
        values.put(COL_4,email);

        long result =db.insert(TABLE_NAME, null,values);
        if (result == -1 )
            return false ;
        else
            return true;
    }
    public boolean checkID(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor  cursor =db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE ID =? ",new String[] {id});
        if(cursor.getCount()>0)
        {
            return true ;
        }else{
            return  false;
        }
    }
    public boolean checkUsername(String username){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor  cursor =db.rawQuery("SELECT * FROM "+TABLE_NAME+" WHERE USERNAME =? ",new String[] {username});
      if(cursor.getCount()>0)
      {
          return true ;
      }else{
          return  false;
      }
    }
    public boolean checkUserPass(String pass , String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String [] columns = {COL_1};
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String [] selectionargs = {username,pass};
        Cursor  cursor = db.query(TABLE_NAME,columns,selection,selectionargs,null,null,null);
        int count = cursor.getCount();
        if(cursor.getCount()>0)
        {
            return true ;
        }else{
            return  false;
        }
    }

    public List<UserAccount> getAccountList(){
        String sql = "select * from " +TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        List<UserAccount> storeAccount = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do{
                int stt = Integer.parseInt(cursor.getString(0));
                String id = cursor.getString(1);
                String username = cursor.getString(2);
                String pass = cursor.getString(3);
                String email = cursor.getString(4);
                storeAccount.add(new UserAccount(stt,id,username,pass,email));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return storeAccount;
    }
}

