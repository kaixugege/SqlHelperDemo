package com.chen.kaixu.dbdemo.dblib;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class MyDatabaseOpenHelper extends SQLiteOpenHelper {

    private Context mContext;

    private static MyDatabaseOpenHelper db;

//    只有加了 synchronized 才会线程安全
//    这个是懒汉式单例
    public static synchronized SQLiteDatabase getInstance(Context context) {
        if (db == null) {
            db = new MyDatabaseOpenHelper(context, "student", null, 1);
        }
        return db.getReadableDatabase();
    }


    public MyDatabaseOpenHelper(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabaseOpenHelper(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public MyDatabaseOpenHelper(@Nullable Context context, @Nullable String name,
                                int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
