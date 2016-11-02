package com.dsz.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;
import static com.dsz.constant.Parameters.DATABASE_NAME;
import static com.dsz.constant.Parameters.KEY_FALG;
import static com.dsz.constant.Parameters.KEY_ICONURL;
import static com.dsz.constant.Parameters.KEY_ID;
import static com.dsz.constant.Parameters.KEY_NAME;
import static com.dsz.constant.Parameters.TABLE_NAME;

/**
 * Created by Administrator on 2016/11/2.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String CREATE_TABLE = "create table "+TABLE_NAME+" ( "+KEY_ID+
            " integer primary key autoincrement,"+KEY_NAME+" text not null,"+
            KEY_ICONURL+" text not null," + KEY_FALG +" BOOLEAN);";



    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
