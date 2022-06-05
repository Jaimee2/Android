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

import com.example.estudiandoaeropuerto.Modelos.HorarioSalida;

import java.util.List;

public class NuevoHorarioSalida extends AppCompatActivity {

    private Aeropuertos aero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_horario);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int posicionOrigen = bundle.getInt("positionAeropuerto");
        int posicionDestino = bundle.getInt("positionDestino");

        EditText horaSalida = findViewById(R.id.horaSalida);
        EditText puertaEmbarque = findViewById(R.id.puertaEmbarque);
        Button btnGuardar = findViewById(R.id.buttonguardarHorario);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                aero = (Aeropuertos) getApplicationContext();
                List<HorarioSalida> horarios = aero.aeropuertos.get(posicionOrigen).getDestinos().get(posicionDestino).getHorarios();
                horarios.add(new HorarioSalida(horaSalida.getText().toString(), puertaEmbarque.getText().toString()));
                horarios.sort(((o1, o2) -> o1.getHoraSalida().compareTo(o2.getHoraSalida())));
                aero.aeropuertos.get(posicionOrigen).getDestinos().get(posicionDestino).setHorarios(horarios);
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
