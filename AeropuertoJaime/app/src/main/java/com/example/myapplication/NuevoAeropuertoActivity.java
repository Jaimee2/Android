package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.Aeropuerto;

import java.util.ArrayList;

public class NuevoAeropuertoActivity extends AppCompatActivity {
    private TravelPointsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevoaeropuertoactivity);

        EditText ciudadOrigen = findViewById(R.id.textCorigen);
        EditText codigo = findViewById(R.id.textCorigen);

        Button buttonGuardar = findViewById(R.id.button);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Casting del tpa
                tpa = (TravelPointsApplication) getApplicationContext();
                //Creamos el objeto aeropuertos
                Aeropuerto aeropuerto = new Aeropuerto(ciudadOrigen.getText().toString(),codigo.getText().toString(),new ArrayList<>());
                //Lo añadimos a la lista de aeropuertos
                tpa.ListAeropuertos.add(aeropuerto);

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

                //setResult(RESULT_OK);
                //finish();
            }
        });

    }
}
