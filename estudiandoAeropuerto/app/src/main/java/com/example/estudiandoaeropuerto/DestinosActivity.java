package com.example.estudiandoaeropuerto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.estudiandoaeropuerto.Modelos.Destino;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DestinosActivity extends AppCompatActivity {

    private ArrayAdapter<Destino> destinoArrayAdapter;
    private Aeropuertos aero;
    private List<Destino> destinoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        //Cogemos los datos del bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int posicion = bundle.getInt("position");

        FloatingActionButton fav = findViewById(R.id.btnAddDestino);
        ListView listView = findViewById(R.id.listDestinos);

        aero = (Aeropuertos) getApplicationContext();

        destinoList = aero.aeropuertos.get(posicion).getDestinos();

        destinoArrayAdapter = new ArrayAdapter<>(this, R.layout.row_layout, R.id.listText,destinoList);
        if(destinoList != null){
            listView.setAdapter(destinoArrayAdapter);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                //Cogemos el texto que aparece en la lista
                String item = listView.getItemAtPosition(position).toString();
                Bundle bundle = new Bundle();

                //Pasamos los datos
                bundle.putInt("positionAeropuerto", posicion);
                bundle.putInt("positionDestino", position);
                bundle.putString("name", item);

                //Creamos la vista y mandamos los datos
                Intent intent = new Intent(getApplicationContext(), HorariosSalidaActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("position", posicion);
                Intent intent = new Intent(getApplicationContext(), NuevoDestinoActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 1);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            destinoArrayAdapter.notifyDataSetChanged();
        }
    }
}
