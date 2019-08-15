package com.caliatumano.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.caliatumano.Categoria;
import com.caliatumano.R;

import java.util.ArrayList;

public class AdapterCatego extends BaseAdapter {

    private Context context;
    private ArrayList<Categoria> list;

    public AdapterCatego(Context context, ArrayList<Categoria> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.categoria_item, null);
        }

        ImageView portada = convertView.findViewById(R.id.portada);
        TextView categoria = convertView.findViewById(R.id.categoria);

        Categoria model = list.get(position);
        portada.setBackgroundResource(model.getImage());
        categoria.setText(model.getNombre());


        return convertView;
    }


    public class Holder {
        public TextView categoria;
        public ImageView portada;
    }
}
