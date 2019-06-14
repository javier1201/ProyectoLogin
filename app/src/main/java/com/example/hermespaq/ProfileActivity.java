package com.example.hermespaq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProfileActivity extends AppCompatActivity {

    private Button button, button2;
    private double latitud, longitud;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageView IMAGES = (ImageView) findViewById(R.id.idImage);
        TextView recogidos = (TextView) findViewById(R.id.idRecogidos);
        TextView disponibles = (TextView) findViewById(R.id.idDisponibles);
        TextView peso = (TextView) findViewById(R.id.idPeso);
        TextView correo = (TextView) findViewById(R.id.idCorreo);
        TextView telefono = (TextView) findViewById(R.id.idTelefono);
        TextView fecha = (TextView) findViewById(R.id.idFecha);
        TextView direccion = (TextView) findViewById(R.id.idDireccion);
        TextView nombre = (TextView) findViewById(R.id.idNombre);

        final Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null)
        {
            recogidos.setText(b.getString("REC"));
            disponibles.setText(b.getString("DISP"));
            peso.setText(b.getString("PES"));
            correo.setText(b.getString("CORR"));
            telefono.setText(b.getString("TEL"));
            fecha.setText(b.getString("FEC"));
            direccion.setText(b.getString("DIR"));
            nombre.setText(b.getString("NOM"));
            IMAGES.setImageResource(b.getInt("Imagen"));
            latitud = b.getDouble("latitud");
            longitud = b.getDouble( "longitud");
        }

        button = (Button) findViewById(R.id.volver1);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity();
            }
        });
        button2 = (Button) findViewById(R.id.btnMap);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent mapa1 = new Intent(ProfileActivity.this,MapsActivity.class);
                mapa1.putExtra("latitud", latitud);
                mapa1.putExtra("longitud", longitud);
                startActivity(mapa1);
            }
        });
    }
    public void startActivity() {
        Intent intent = new Intent(this, Customers.class);
        startActivity(intent);
    }
}

