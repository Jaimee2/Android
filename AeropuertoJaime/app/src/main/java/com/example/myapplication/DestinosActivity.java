package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.Aeropuerto;
import com.example.myapplication.Modelos.Destino;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DestinosActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;
    private ListView listaDestinos;
    private int posicion_aeropuerto;
    private ArrayAdapter<Destino> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destinosactivity);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            posicion_aeropuerto = bundle.getInt("posicion");
            //Casting tpa
            tpa = (TravelPointsApplication) getApplicationContext();

            //Casting de la listView principal
            listaDestinos = findViewById(R.id.listaDestinos);
            //Se imprime los destinos del aeropuerto posicion_aeropuerto
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                    tpa.ListAeropuertos.get(posicion_aeropuerto).getDestinos());

            try {
                listaDestinos.setAdapter(adapter);
            }catch (Exception e){}


            listaDestinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplicationContext(), HorarioSalidaActivity.class);
                    intent.putExtra("posicion_destino",position);
                    intent.putExtra("posicion_aeropuerto",posicion_aeropuerto);
                    startActivity(intent);
                }
            });

            //Casting float buton2
            FloatingActionButton botonFlotante = findViewById(R.id.floatingActionButton2);

            botonFlotante.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Cuado sea pulsado nos vamos a crear un nuevo aeropuerto
                    Intent intent = new Intent(getApplicationContext(), NuevoDestinoActivity.class);
                    intent.putExtra("posicion_aeropuerto",posicion_aeropuerto);
                    startActivity(intent);
                }
            });

        }
    }

}
