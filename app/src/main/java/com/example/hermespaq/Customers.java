package com.example.hermespaq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Customers extends AppCompatActivity {
    ListView lista;

    String [][] datos = {
            {"Antonio Galvan", "2 paquetes", "2", "10lb", "antoniogalvan@gmail.com", "809-555-4555", "05/06/1986", "Piantini", "3"},
            {"Julio Castro", "1 paquete", "1", "5lb", "j.castro@hotmail.com", "809-750-8888", "03/05/1990", "Naco", "6"},
            {"Maria Mejia", "3 paquetes", "3", "17lb", "mar.m@yahoo.es", "809-732-3434", "0|/02/1995", "Arroyo Hondo", "8"},
            {"Laura Pineda", "7 paquetes", "7", "30lb", "l.pineda@gmail.com", "829-330-5656", "05/12/1999", "Bella Vista", "20"},
    };
    int [] IMAGES = {R.drawable.hola1, R.drawable.hola2, R.drawable.hola3, R.drawable.hola4};
    Double [] coordenada1 = {18.474603, 18.475163, 18.499419, 18.450046};
    double [] coordenada2 = {-69.928120, -69.930050, -69.970684, -69.944756};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        lista = (ListView) findViewById(R.id.listView);

        lista.setAdapter(new Adaptador(this, datos, IMAGES));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent visorDetalles = new Intent(view.getContext(), ProfileActivity.class);
                visorDetalles.putExtra("NOM", datos[position][0]);
                visorDetalles.putExtra("REC", datos[position][8]);
                visorDetalles.putExtra("DISP", datos[position][2]);
                visorDetalles.putExtra("PES", datos[position][3]);
                visorDetalles.putExtra("CORR", datos[position][4]);
                visorDetalles.putExtra("TEL", datos[position][5]);
                visorDetalles.putExtra("FEC", datos[position][6]);
                visorDetalles.putExtra("DIR", datos[position][7]);
                visorDetalles.putExtra("Imagen", IMAGES[position]);
                visorDetalles.putExtra("latitud", coordenada1[position]);
                visorDetalles.putExtra("longitud", coordenada2[position]);
                startActivity(visorDetalles);
            }
        });
    }
}
