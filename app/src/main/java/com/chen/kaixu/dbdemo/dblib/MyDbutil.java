package com.chen.kaixu.dbdemo.dblib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MyDbutil {

    private SQLiteDatabase db;
    private Context context;

    public MyDbutil(Context context, String dbName, int ver) {
        this.context = context;
        db = MyDatabaseOpenHelper.getInstance(context);
    }

    /**
     * 查询所有数据
     *
     * @return Cursor
     */
    public Cursor findAll() {
        Cursor cursor = db.rawQuery("select * from t_stu", null);
        return cursor;
    }


    /**
     * 添加数据
     */
    public void insert(String name, int age, String sex) {
        db.execSQL("insert into t_stu values(null,?,?,?)", new String[]{name,
                age + "", sex});
    }

    /**
     * 删除数据
     *
     * @param id
     */
    public void del(int id) {
        db.execSQL("delete from t_stu where _id=?", new String[]{id + ""});
    }



    public boolean findTableExiset(String tableName) {
        Cursor cursor = db.rawQuery("select * from sqlite_master where type = 'table' and name = ?",
                new String[]{tableName + ""});
        Log.d("数据库 ：：：", "" + cursor.getCount());
        cursor.close();
        if (cursor.getCount() == 0) {
            return true;
        } else {
            return false;
        }
    }



    /**
     * 根据id查询数据
     *
     * @param id
     * @return Cursor
     */
    public Cursor findById(int id) {
        Cursor cursor = db.rawQuery("select * from t_stu where _id=?",
                new String[]{id + ""});
        return cursor;
    }

    /**
     * 修改数据
     */
    public void update(String name, int age, String sex, int id) {
        db.execSQL("update t_stu set s_name=?,s_age=?,s_sex=? where _id=?",
                new Object[]{name, age, sex, id});
    }
}
