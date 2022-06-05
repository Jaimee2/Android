package com.example.estudiandoaeropuerto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiandoaeropuerto.Modelos.HorarioSalida;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class HorariosSalidaActivity extends AppCompatActivity {

    private Aeropuertos aero;
    private ArrayAdapter<HorarioSalida> hora_adapter;
    private int posicionAeropuerto;
    private int posicionDestino;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horarios_salida);

        aero = (Aeropuertos) getApplicationContext();

        FloatingActionButton fav = findViewById(R.id.bntAddHorarios);
        ListView listView = findViewById(R.id.listHoras);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        posicionAeropuerto = bundle.getInt("positionAeropuerto");
        posicionDestino = bundle.getInt("positionDestino");

        List<HorarioSalida> horas = aero.aeropuertos.get(posicionAeropuerto).getDestinos().get(posicionDestino).getHorarios();
        hora_adapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText, horas);
        if(horas != null){
            listView.setAdapter(hora_adapter);
        }

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("positionAeropuerto", posicionAeropuerto);
                bundle.putInt("positionDestino", posicionDestino);
                Intent intent = new Intent(getApplicationContext(), NuevoHorarioSalida.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            hora_adapter.notifyDataSetChanged();
        }
    }
}
