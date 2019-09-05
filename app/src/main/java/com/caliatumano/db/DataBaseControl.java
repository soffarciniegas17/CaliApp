package com.caliatumano.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.caliatumano.R;

public class DataBaseControl extends SQLiteOpenHelper {

    private static int version = 1;
    private static final String DB_NAME = "CaliApp.db";
    private static final String TABLE_PREGUNTAS = "CREATE TABLE pregunta(pre_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "pre_texto TEXT, catego_id INTEGER, pre_estado INTEGER, pre_nivel TEXT)";
    private static final String TABLE_RESPUESTAS = "CREATE TABLE respuesta(resp_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "resp_texto TEXT, pre_id INTEGER, resp_detalle TEXT, resp_bandera INTEGER)";
    private static final String TABLE_CATEGORIA = "CREATE TABLE categoria(catego_id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "catego_texto TEXT, catego_image INTEGER)";
    private static final String TABLE_USUARIO = "CREATE TABLE usuario(codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "usuario TEXT, clave TEXT, nivel INTEGER, avatar TEXT)";


    public DataBaseControl(Context context) {
        super(context, DB_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_PREGUNTAS);
        db.execSQL(TABLE_RESPUESTAS);
        db.execSQL(TABLE_CATEGORIA);
        db.execSQL(TABLE_USUARIO);

        db.execSQL("INSERT INTO categoria (catego_texto,catego_image) VALUES('Arte', " + R.drawable.catego_arte + ")"); // 1
        db.execSQL("INSERT INTO categoria (catego_texto,catego_image) VALUES('Historia', " + R.drawable.catego_historia + ")"); // 2
        db.execSQL("INSERT INTO categoria (catego_texto,catego_image) VALUES('Festividades', " + R.drawable.catego_festividades + ")"); //3
        db.execSQL("INSERT INTO categoria (catego_texto,catego_image) VALUES('Lugares', " + R.drawable.catego_lugares + ")"); //4

        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('¿Quienes fueron los directores del cortometraje Oiga vea?'," +
                "1, 0, '1')");
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('Maria, es la única novelda de Jorge Isaac, la cúal es considerada una de las obras más destacadas" +
                " de la literatura hispanica. ¿De que trata esta novela?', 1, 0, '2')");


        //---------------------
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('El 26 de febrero de 1971 ocurrió La Masacre estudiantil más memorada de la historia cuando estudiantes," +
                " de Univalle trataron de retorma su campus. ¿Bajo el mandato de quién sucedio este hecho?',2, 0, '1')");
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('¿En que año Santiago de Cali pasó a ser la capital del (en esa epoca) renaciente Valle del Cauca?'," +
                "2, 0, '2')");

        //--------------------
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('La feria de Cali fue motivada para transformar el dolor de una tregedia en alegría y festividad" +
                " ¿Qué tragedia condecoro esta festividad?', 3, 0, '1')");
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('El Petronio es una festividad músical reconocida mundialmente que consiste en...'," +
                "3, 0, '2')");

        //--------------------
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('Uno de los barrios más antiguos de Cali resalta en una de las tantas lomas de Cali, es considerada patrimonio de la ciudad," +
                " y dentro de él, se encuentra una de las iglesias más antiguas de Colombia.',4, 0, '1')");
        db.execSQL("INSERT INTO pregunta(pre_texto, catego_id,pre_estado, pre_nivel ) VALUES('La Ermita conserva una de las imagenes con más de tres siglos como Nuestra señora de los Dolores, San Francisco, ect. En" +
                " su lateral izquierdo contiene una de las más antiguas imagenes que conserva la iglesia y es una representación vallecaucana.',4, 0, '2')");

        //-------------------- RESPUESTAS
        db.execSQL("INSERT INTO respuesta (resp_texto, pre_id, resp_detalle, resp_bandera) VALUES ('La tragedia de Efráin', 2, " +
                "'', 0)");
        db.execSQL("INSERT INTO respuesta (resp_texto, pre_id, resp_detalle, resp_bandera) VALUES ('Andres Caicedo y Luis Ospina', 1, " +
                "'', 0)");
        db.execSQL("INSERT INTO respuesta (resp_texto, pre_id, resp_detalle, resp_bandera) VALUES ('Luis Ospina y Carlos Mayolo', 1, " +
                "'', 1)");
        db.execSQL("INSERT INTO respuesta (resp_texto, pre_id, resp_detalle, resp_bandera) VALUES ('Diego León Giraldo y Patricia Restrepo', 1, " +
                "'', 0)");
        db.execSQL("INSERT INTO respuesta (resp_texto, pre_id, resp_detalle, resp_bandera) VALUES ('Fernando velez y Carlos Mayolo', 1, " +
                "'', 0)");


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
        //  cursor.close();
        return cursor;
    }

    public void execute(String sql) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
        db.close();
    }


}
