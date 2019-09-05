package com.caliatumano.controllers;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.caliatumano.models.Categoria;
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
        if(cursorCatego != null){
            while (cursorCatego.moveToNext()){
                list.add(new Categoria(cursorCatego.getString(0),
                                       cursorCatego.getString(1),
                                       cursorCatego.getInt(2)));
            }
        }

        return list;
    }
}
