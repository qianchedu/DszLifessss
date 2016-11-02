package com.dsz.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dsz.bean.ModelAddName;

import java.util.ArrayList;
import java.util.List;

import static com.dsz.constant.Parameters.KEY_FALG;
import static com.dsz.constant.Parameters.KEY_ICONURL;
import static com.dsz.constant.Parameters.KEY_ID;
import static com.dsz.constant.Parameters.KEY_NAME;
import static com.dsz.constant.Parameters.TABLE_NAME;

/**
 * Created by Administrator on 2016/11/2.
 */

public class ModelAddDB {

    private Context context;

    public ModelAddDB(Context context){
        this.context = context;
    }

    /**
     * 添加数据
     * @param modelAddName
     */
    public void insert(ModelAddName modelAddName){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_NAME,modelAddName.getModelName());
        contentValues.put(KEY_ICONURL,modelAddName.getModelIconUrl());
        contentValues.put(KEY_FALG,modelAddName.isModelFlag());
        db.insert(TABLE_NAME,null,contentValues);
        db.close();
    }

    /**
     * 获取数据库的数据 根据名称来查询
     * @param name
     * @return
     */
    public ModelAddName getModelName(String name){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();

        //cursor对象返回查询结果
        Cursor cursor = db.query(TABLE_NAME,
                new String[]{KEY_ID,KEY_NAME,KEY_ICONURL,KEY_FALG},
                KEY_NAME + "=?",
                new String[]{name},
                null,null,null,null
                );

        ModelAddName modelAddName = null;
        if(cursor.moveToFirst()){
            modelAddName = new ModelAddName(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getInt(3)>0);
        }
        return modelAddName;
    }


    /**
     * 获取数据的总条数
     * @return
     */
    public int getModelNameCounts(){
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        cursor.close();

        return  cursor.getCount();
    }

    /**
     * 获取总条数的数据
     * @return
     */
    public List<ModelAddName> getAllModel(){
        List<ModelAddName> modelAddNameList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                ModelAddName modelAddName = new ModelAddName();
                boolean fl = cursor.getInt(3) > 0;
                modelAddName.setModelID(Integer.parseInt(cursor.getString(0)));
                modelAddName.setModelName(cursor.getString(1));
                modelAddName.setModelIconUrl(cursor.getString(2));
                modelAddName.setModelFlag(fl);
                modelAddNameList.add(modelAddName);
            }while (cursor.moveToNext());
        }
        return modelAddNameList;
    }




    /**
     * 更新数据
     * @param modelAddName
     * @return
     */
    public int updateModel(ModelAddName modelAddName){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FALG,modelAddName.isModelFlag());
        return db.update(TABLE_NAME,contentValues,KEY_ID + "=?",new String[]{String.valueOf(modelAddName.getModelID())});
    }


    /**
     * 更新数据
     * @param modelAddName
     * @return
     */
    public int updateModel(ModelAddName modelAddName,boolean flag){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FALG,flag);

        return db.update(TABLE_NAME,
                contentValues,
                KEY_ID + "=?",
                new String[]{String.valueOf(modelAddName.getModelID())});
    }

    /**
     * 更新数据
     * @param modelAddName
     * @return
     */
    public int updateModel(ModelAddName modelAddName,int id,boolean flags){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FALG,flags);

        return db.update(TABLE_NAME,
                contentValues,
                KEY_ID + "=?",
                new String[]{String.valueOf(id)});
    }



    /**
     * 删除数据
     * @param modelAddName
     */
    public void deleteModel(ModelAddName modelAddName){
        SQLiteHelper sqLiteHelper = new SQLiteHelper(context);
        SQLiteDatabase db = sqLiteHelper.getWritableDatabase();
        db.delete(
                TABLE_NAME,
                KEY_ID + "=?",
                new String[]{String.valueOf(modelAddName.getModelID())});
        db.close();
    }


}
