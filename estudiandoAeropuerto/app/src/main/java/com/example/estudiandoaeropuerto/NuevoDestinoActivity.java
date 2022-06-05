package com.example.estudiandoaeropuerto;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiandoaeropuerto.Modelos.Destino;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NuevoDestinoActivity extends AppCompatActivity {
    private Aeropuertos aero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_destino);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int posicion = bundle.getInt("position");

        EditText nombre = findViewById(R.id.ciudadDestino);
        EditText distancia = findViewById(R.id.distanciaDestino);
        Button btnGuardar = findViewById(R.id.buttonguardarDestino);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                aero = (Aeropuertos) getApplicationContext();
                List<Destino> dest = aero.aeropuertos.get(posicion).getDestinos();
                Destino destino = new Destino();
                destino.setNombreDestino(nombre.getText().toString());
                destino.setDistanciaOrigen(Integer.parseInt(distancia.getText().toString()));
                destino.setHorarios(new ArrayList<>());
                dest.add(destino);
                dest.sort(Comparator.comparing(Destino::getDistanciaOrigen));
                aero.aeropuertos.get(posicion).setDestinos(dest);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
