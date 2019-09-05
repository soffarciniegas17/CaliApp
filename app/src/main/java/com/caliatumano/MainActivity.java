package com.caliatumano;

import android.app.Dialog;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    EditText pass2, pass, user;
    TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.usuario);
        pass = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.contrasena2);
        texto = findViewById(R.id.txt_titulo);

        Bundle extras = getIntent().getExtras();
        String crud = extras.getString("crud");

        if (crud.equals("crear")) {
            texto.setText("Crear cuenta");
            pass2.setVisibility(View.VISIBLE);
        }

    }

    public void pasar(View view) {
        if (pass.getText().toString().equals("univalle") && user.getText().toString().equals("mera")) {
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
            finish();
        } else if (pass.getText().toString().equals("univalle")) {
            Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
        } else if (user.getText().toString().equals("mera")) {
            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();

        }


    }
}
