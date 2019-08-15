package com.caliatumano;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.caliatumano.adapters.AdapterCatego;

import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        gridView = findViewById(R.id.grid_view);

        ArrayList<Categoria> list= new ArrayList<>();
        list.add(new Categoria("Arte", R.drawable.catego_arte));
        list.add(new Categoria("Historia", R.drawable.catego_historia));
        list.add(new Categoria("Festividades", R.drawable.catego_festividades));
        list.add(new Categoria("Lugares", R.drawable.catego_lugares));


        AdapterCatego adapterCatego = new AdapterCatego(this, list);
        gridView.setAdapter(adapterCatego);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
