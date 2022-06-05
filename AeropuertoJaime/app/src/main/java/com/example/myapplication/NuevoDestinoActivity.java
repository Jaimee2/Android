package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NuevoDestinoActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevodestinoactivity);

        EditText ciudadDestino = findViewById(R.id.CiudadDestino);
        EditText distancia = findViewById(R.id.distancia);

        Button buttonGuardar = findViewById(R.id.button);

    }
}
