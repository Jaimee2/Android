package com.example.estudiandoaeropuerto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiandoaeropuerto.Modelos.Aeropuerto;

import java.util.ArrayList;

public class NuevoAeropuertoActivity extends AppCompatActivity {
    private Aeropuertos aero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_aeropuerto);

        EditText ciudadOrigen = findViewById(R.id.ciudadOrigen);
        EditText codigoOrigen = findViewById(R.id.codigoOrigen);
        Button btnGuardar = findViewById(R.id.buttonguardarAeropuerto);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aero = (Aeropuertos) getApplicationContext();
                Aeropuerto aeropuerto = new Aeropuerto();
                aeropuerto.setNombreAeropuerto(ciudadOrigen.getText().toString());
                aeropuerto.setCodigo(codigoOrigen.getText().toString());
                aeropuerto.setDestinos(new ArrayList<>());
                aero.aeropuertos.add(aeropuerto);
                setResult(RESULT_OK);
                finish();
            }
        });


    }
}
