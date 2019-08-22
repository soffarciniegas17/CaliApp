package com.caliatumano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FinalJuego extends AppCompatActivity {

    TextView txt_titulo, txt_buenas, txt_malas;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_juego);
        extras = getIntent().getExtras();

        txt_titulo = findViewById(R.id.txt_main);
        txt_buenas = findViewById(R.id.txt_buena);
        txt_malas = findViewById(R.id.txt_mala);

        txt_buenas.setText(extras.getString("buenas"));
        txt_malas.setText(extras.getString("malas"));
    }


    public void finalJuego(View v){
        startActivity(new Intent(this, Menu.class));
    }
}
