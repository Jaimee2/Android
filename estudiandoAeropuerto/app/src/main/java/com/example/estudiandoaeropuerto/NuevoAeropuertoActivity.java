package com.example.estudiandoaeropuerto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiandoaeropuerto.Modelos.Aeropuerto;

import java.util.ArrayList;

public class NuevoAeropuertoActivity extends AppCompatActivity {
    //Es como tpa
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
                //Casting del tpa
                aero = (Aeropuertos) getApplicationContext();
                //Se crea el objeto aeropuerto
                Aeropuerto aeropuerto = new Aeropuerto();
                //Nombre del aeropuerto es la ciudad de origne
                aeropuerto.setNombreAeropuerto(ciudadOrigen.getText().toString());
                //Codigo de origen
                aeropuerto.setCodigo(codigoOrigen.getText().toString());
                //Lista de destinos de momento vacia
                aeropuerto.setDestinos(new ArrayList<>());
                //Se añade a la lista de aeropuertos
                aero.aeropuertos.add(aeropuerto);

                setResult(RESULT_OK);
                finish();
            }
        });


    }
}
