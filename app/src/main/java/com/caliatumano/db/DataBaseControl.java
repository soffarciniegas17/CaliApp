package com.caliatumano.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DataBaseControl extends SQLiteOpenHelper {

    private static int version = 1;
    private static final String DB_NAME = "CaliApp.db";
    private static final String TABLE_PREGUNTAS = "CREATE TABLE pregunta (pre_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "pre_texto TEXT, catego_id INTEGER, resp_id INTEGER, resp_estado INTEGER)";
    private static final String TABLE_RESPUESTAS = "CREATE TABLE respuesta (resp_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "resp_texto TEXT, pre_id INTEGER, resp_detalle TEXT)";
    private static final String TABLE_CATEGORIA = "CREATE TABLE categoria (catego_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "catego_texto TEXT, catego_image INTEGER)";


    public DataBaseControl(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_PREGUNTAS);
        db.execSQL(TABLE_RESPUESTAS);
        db.execSQL(TABLE_CATEGORIA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS pregunta");
        db.execSQL("DROP TABLE IF EXISTS respuesta");
        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL(TABLE_PREGUNTAS);
        db.execSQL(TABLE_RESPUESTAS);
        db.execSQL(TABLE_CATEGORIA);
    }

    public void insert(ContentValues content, String table) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(table, null, content);
        db.close();
    }

    public Cursor select(String sql) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        cursor = db.rawQuery(sql, null);
        cursor.close();
        return cursor;
    }

    public void excute(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }




}
