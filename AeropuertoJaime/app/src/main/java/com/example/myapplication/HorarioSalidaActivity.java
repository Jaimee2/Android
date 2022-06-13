package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.HorarioSalida;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HorarioSalidaActivity extends AppCompatActivity {

    private int posicion_aeropuerto, posicion_destino;
    private TravelPointsApplication tpa;
    private ListView listaHorarios;
    private ArrayAdapter<HorarioSalida> adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horariosalidaactivity);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            posicion_aeropuerto = bundle.getInt("posicion_aeropuerto");
            posicion_destino = bundle.getInt("posicion_destino");
            //Casting tpa
            tpa = (TravelPointsApplication) getApplicationContext();

            //Casting de la listView principal
            listaHorarios = findViewById(R.id.LitaHorarios);

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                    tpa.ListAeropuertos.get(posicion_aeropuerto).getDestinos().get(posicion_destino).getHorariosSalidaList());

            try {
                listaHorarios.setAdapter(adapter);
            } catch (Exception e) {
            }


            //Casting float buton
            FloatingActionButton botonFlotante = findViewById(R.id.floatingActionButton3);

            botonFlotante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Cuado sea pulsado nos vamos a crear un nuevo aeropuerto
                    Intent intent = new Intent(getApplicationContext(), NuevoHorarioSalidaActivity.class);

                    intent.putExtra("posicion_destino",posicion_destino);
                    intent.putExtra("posicion_aeropuerto",posicion_aeropuerto);

                    startActivity(intent);
                }
            });


        }
    }
}
