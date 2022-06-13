package com.example.gestionfacturasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionfacturasapp.Modelos.Articulo;
import com.example.gestionfacturasapp.Modelos.Factura;

public class HistorialActivity extends AppCompatActivity {
    private ListView listaFacturas;
    private TravelPointsApplication tpa;
    private int ID;
    private  ArrayAdapter<Factura> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historial_activity);

        //Que id de factura entra
        Intent intent = getIntent();
        ID = intent.getExtras().getInt("ID");

        //Lista main
        listaFacturas = findViewById(R.id.ListaFacturas);

        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();


        adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tpa.ListFacturas);

        listaFacturas.setAdapter(adapter);


        listaFacturas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //La posicion de la factura es el ID
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("ID",position);
                startActivity(intent);
            }
        });
    }

    //Ir a Main
    public void irMain(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
    }
}
