package com.example.hermespaq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater=null;

    Context contexto;
    String [][] datos;
    int [] IMAGES;
    ListView lista;
    public Adaptador(Context contexto, String[][] datos, int[] imagenes){
        this.contexto = contexto;
        this.datos = datos;
        this.IMAGES = imagenes;
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {


        final View vista = inflater.inflate(R.layout.customlayout, null);
        TextView titulo = (TextView) vista.findViewById(R.id.textView_name);
        TextView descripcion = (TextView) vista.findViewById(R.id.textView_description);
        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView2);
        titulo.setText(datos[i][0]);
        descripcion.setText(datos[i][1]);
        imagen.setImageResource(IMAGES[i]);

        return vista;
    }

    @Override
    public int getCount() {
        return IMAGES.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
