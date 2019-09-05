package com.caliatumano.controllers;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.caliatumano.db.DataBaseControl;
import com.caliatumano.models.Pregunta;
import com.caliatumano.models.Respuesta;

import java.util.ArrayList;

public class EncuestaControl {

    private Context context;

    public EncuestaControl(Context context) {
        this.context = context;
    }


    private ArrayList<Respuesta> getRespuestas(int id) {
        ArrayList<Respuesta> list = new ArrayList<>();

        DataBaseControl db = new DataBaseControl(context);
        Cursor cursor = db.select("SELECT * FROM RESPUESTA WHERE PRE_ID=" + id);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                list.add(new Respuesta(cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4)));
            }
        }

        return list;
    }

    public ArrayList<Pregunta> getEncuesta(int categoria, String nivel) {
        ArrayList<Pregunta> listPregunta = new ArrayList<>();

        DataBaseControl db = new DataBaseControl(context);
        Cursor cursor = db.select("SELECT * FROM PREGUNTA WHERE catego_id=" + categoria +
                                    " AND pre_estado=0 AND pre_nivel ='" + nivel + "' ");

        if (cursor != null) {
            while (cursor.moveToNext()) {
                listPregunta.add(new Pregunta(
                        cursor.getInt(0),
                        cursor.getString(1),
                        "" + categoria,
                        cursor.getString(3),
                        getRespuestas(cursor.getInt(0))));
            }
        }

        return listPregunta;

    }


}
