package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConsumicionActivity extends AppCompatActivity {

    TravelPointsApplication tpa;
    ListView listaProductos;
    public ArrayList<String> ListaProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumicionactivity);

        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();
        //Casting de la listView principal
        listaProductos = findViewById(R.id.listaProductos2);

        //Variables auxiliares para el listado
        ListaProductos = new ArrayList<>();
        String nombre;
        int precio;

        for (int i=0;i<tpa.ListaProductos.size();i++) {

            nombre = tpa.ListaProductos.get(i).getNombre();
            precio = tpa.ListaProductos.get(i).getPrecio();

            ListaProductos.add(nombre+"    " +"("+ precio + ")");
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ListaProductos);

        listaProductos.setAdapter(adapter);

        listaProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),NuevaConsumicionActivity.class);
                intent.putExtra("posicion", position);
                startActivity(intent);
            }
        });


    }
    //Ir a main
    public void irMain(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}

