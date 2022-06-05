package com.example.estudiandoaeropuerto;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.estudiandoaeropuerto.Modelos.Aeropuerto;
import com.example.estudiandoaeropuerto.Modelos.Destino;
import com.example.estudiandoaeropuerto.Modelos.HorarioSalida;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainAeropuertoActivity extends AppCompatActivity {

    private ListView listView;
    private Aeropuertos aero;
    private ArrayAdapter<Aeropuerto> aeropuerto_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listaAeropuertos);
        FloatingActionButton fav = findViewById(R.id.btnAddAeropuerto);

        aero = (Aeropuertos) getApplicationContext();
        initalizeList(aero.aeropuertos);

        aeropuerto_adapter = new ArrayAdapter<Aeropuerto>(this, R.layout.row_layout, R.id.listText, aero.aeropuertos);
        try {
            listView.setAdapter(aeropuerto_adapter);
        } catch (Exception ex) {}

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Cogemos el texto de la linea
                String item = listView.getItemAtPosition(position).toString();
                Bundle bundle = new Bundle();

                //Le pasamos los datos
                bundle.putInt("position", position);
                bundle.putString("name", item);

                //Creamos la nueva vusta y pasamos los datos del bundle
                Intent intent = new Intent(getApplicationContext(), DestinosActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NuevoAeropuertoActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK) {
            aeropuerto_adapter.notifyDataSetChanged();
        }
    }

    public void initalizeList(List<Aeropuerto> lista_aeropuerto){
        Aeropuerto ae = new Aeropuerto();
        ae.setNombreAeropuerto("Pamplona");
        ae.setCodigo("PM");

        Destino des = new Destino();
        des.setNombreDestino("Madrid");
        des.setDistanciaOrigen(25);

        List<HorarioSalida> hor = new ArrayList<>();
        HorarioSalida horario = new HorarioSalida();
        horario.setHoraSalida("19:45");
        horario.setPuertaSalida("1");
        hor.add(horario);
        des.setHorarios(hor);

        List<Destino> dest = new ArrayList<>();
        dest.add(des);

        ae.setDestinos(dest);

        lista_aeropuerto.add(ae);
    }
}