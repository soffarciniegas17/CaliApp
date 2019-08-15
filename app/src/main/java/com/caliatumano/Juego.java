package com.caliatumano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Juego extends AppCompatActivity {

    String categoria = "";
    TextView textCatego = null;
    int catego_id = 0;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        textCatego = findViewById(R.id.categoria_tx);

        Bundle extras = getIntent().getExtras();
        categoria = extras.getString("categoria");
        textCatego.setText(categoria);

    }


    public String getPreguntas(int position, int categoria) {
        String pregunta = "";
        switch (categoria) {
            case 0:
                if (position == 1) {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                } else {
                    pregunta = "";
                }

                break;
            case 1:

                if (position == 1) {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                } else {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                }
                break;
            case 2:
                if (position == 1) {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                } else {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                }
                break;
            case 3:
                if (position == 1) {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                } else {
                    pregunta = "¿Quienes fueron los directores del cortometraje 'Oiga vea'?";
                }
                break;

        }

        return pregunta;
    }

}
