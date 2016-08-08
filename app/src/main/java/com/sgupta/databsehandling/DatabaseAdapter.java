package com.sgupta.databsehandling;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseAdapter {

    Context mContext;
    Database mDatabase;
    public DatabaseAdapter(Context context) {
        mContext = context;
        mDatabase  = new Database(context);
    }

    public long insert(String name){

        SQLiteDatabase sqLiteDatabase = mDatabase.getWritableDatabase();
        ContentValues contentValues  = new ContentValues();
        contentValues.put(Database.NAME,name);
        long id= sqLiteDatabase.insert(Database.TABLE_NAME,null,contentValues);
        return id;
    }

    class Database extends SQLiteOpenHelper{
        private static final String DATABASE_NAME = "data";
        private static final String TABLE_NAME = "TABLE1";
        private static final String UID = "_id";
        private static final String NAME = "Name";
        private static final int DATABASE_VERSION = 1;

        Database(Context context){
            super(context,DATABASE_NAME,null,DATABASE_VERSION);

        }
        public void onCreate(SQLiteDatabase db){
            try{
                db.execSQL("CREATE TABLE TABLE1(_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR(255));");
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion ){

        }
    }


}
