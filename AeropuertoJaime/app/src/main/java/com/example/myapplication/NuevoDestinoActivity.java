package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.Destino;
import com.example.myapplication.Modelos.HorarioSalida;

import java.util.ArrayList;
import java.util.List;

public class NuevoDestinoActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;
    EditText ciudadDestino, distancia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevodestinoactivity);

        ciudadDestino = findViewById(R.id.CiudadDestino);
        distancia = findViewById(R.id.distancia);

        Button buttonGuardar = findViewById(R.id.button2);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Casting del tpa
                tpa = (TravelPointsApplication) getApplicationContext();
                List<HorarioSalida> hS = new ArrayList<>();
                //Creamos el objeto Destino
                Destino destino = new Destino(ciudadDestino.getText().toString(),Integer.valueOf(distancia.getText().toString()),hS);
                Bundle bundle = getIntent().getExtras();
                int posicion_aeropuerto = bundle.getInt("posicion_aeropuerto");
                //Lo añadimos a la lista de aeropuertos
                List<Destino> dest = tpa.ListAeropuertos.get(posicion_aeropuerto).getDestinos();
                dest.add(destino);
                tpa.ListAeropuertos.get(posicion_aeropuerto).setDestinos(dest);

                Intent intent = new Intent(getApplicationContext(), DestinosActivity.class);
                intent.putExtra("posicion",posicion_aeropuerto);
                startActivity(intent);
            }
        });
    }
}
