package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProductosActivity extends AppCompatActivity {

    TravelPointsApplication tpa;
    ListView listaProductos;
    public ArrayList<String> ListaProductos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productosactivity);
        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();
        //Casting de la listView principal
        listaProductos = findViewById(R.id.listaProductos);

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

    }
    //Ir a NuevoProductoActivity
    public void irNuevoProductoActivity(View view){
        Intent intent = new Intent(getApplicationContext(),NuevoProductoActivity.class);
        startActivity(intent);
    }
    //Ir a main
    public void irMain(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
