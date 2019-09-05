package com.caliatumano;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.caliatumano.adapters.AdapterCatego;
import com.caliatumano.controllers.CategoriaControl;
import com.caliatumano.models.Categoria;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        gridView = findViewById(R.id.grid_view);


        final ArrayList<Categoria> list = new CategoriaControl(this).getCategorias();
        AdapterCatego adapterCatego = new AdapterCatego(this, list);
        gridView.setAdapter(adapterCatego);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(getApplicationContext(), Juego.class);
                in.putExtra("categoria", list.get(position).getNombre());
                in.putExtra("id_categoria", list.get(position).getId());
                in.putExtra("nivel", "1");
                startActivity(in);

            }
        });
    }

    public void setPerfil(View v){

    }
}
