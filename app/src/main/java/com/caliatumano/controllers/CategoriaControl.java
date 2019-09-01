package com.caliatumano.controllers;

import android.content.Context;
import android.database.Cursor;

import com.caliatumano.Categoria;
import com.caliatumano.db.DataBaseControl;

import java.util.ArrayList;

public class CategoriaControl {

    private Context context;

    public CategoriaControl(Context context) {
        this.context = context;
    }

    public ArrayList<Categoria> getCategorias(){
        DataBaseControl db = new DataBaseControl(this.context);
        Cursor cursorCatego  = db.select("SELECT * FROM CATEGORIA");
        ArrayList<Categoria> list =  new ArrayList<>();
        if(cursorCatego.moveToFirst()){
            while (cursorCatego.moveToNext()){
                list.add(new Categoria(cursorCatego.getString(0), cursorCatego.getInt(1)));
            }
        }

        cursorCatego.close();
        return list;
    }
}
