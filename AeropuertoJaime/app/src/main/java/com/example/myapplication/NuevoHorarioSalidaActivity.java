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


public class NuevoHorarioSalidaActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;
    EditText horaSalida, puertaEmbarque;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevohorariosalida);

        horaSalida = findViewById(R.id.editTextTextPersonName);
        puertaEmbarque = findViewById(R.id.editTextTextPersonName2);

        Button buttonGuardar = findViewById(R.id.button4);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Casting del tpa
                tpa = (TravelPointsApplication) getApplicationContext();

                //Creamos el objeto HorarioSalida
                HorarioSalida horarioSalida = new HorarioSalida(horaSalida.getText().toString(),puertaEmbarque.getText().toString());
                Bundle bundle = getIntent().getExtras();
                int posicion_aeropuerto = bundle.getInt("posicion_aeropuerto");
                int posicion_destino = bundle.getInt("posicion_destino");
                //Obtenemos la lista de horarios de salida
                List<HorarioSalida> horarioSalidaList = tpa.ListAeropuertos.get(posicion_aeropuerto).getDestinos().get(posicion_destino).getHorariosSalidaList();
                horarioSalidaList.add(horarioSalida);
                tpa.ListAeropuertos.get(posicion_aeropuerto).getDestinos().get(posicion_destino).setHorariosSalidaList(horarioSalidaList);

                Intent intent = new Intent(getApplicationContext(), HorarioSalidaActivity.class);
                intent.putExtra("posicion_aeropuerto",posicion_aeropuerto);
                intent.putExtra("posicion_destino",posicion_destino);
                startActivity(intent);

            }
        });



    }
}
