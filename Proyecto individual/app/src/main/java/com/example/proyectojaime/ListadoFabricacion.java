package com.example.proyectojaime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ListadoFabricacion extends AppCompatActivity {


    public ListView listView;
    public ArrayList<String> pedidos;
    TravelPointsApplication tpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_fabricacion);
        //Casting de la listView principal
        listView = findViewById(R.id.lista2);

        //Leemos los elementos guardados en VariablesGlobales.ListaOrdenFabricacion
        pedidos = new ArrayList<>();
        String tipoAero;
        Integer ID;
        String date;

        SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");


        //V2
        tpa = (TravelPointsApplication)getApplicationContext();

        for (int i=0;i<tpa.ListaOrdenFabricacion.size();i++) {
            ID = tpa.ListaOrdenFabricacion.get(i).getID();
            tipoAero = tpa.ListaOrdenFabricacion.get(i).getTipoAerogenerador();
            date = tpa.ListaOrdenFabricacion.get(i).getFechaProgramada();

            if (tpa.ListaOrdenFabricacion.get(i).getUrgencia()){
                pedidos.add( "     "+ID.toString() + "                 "+tipoAero + "              "+ "URGENTE");
            }else {
                pedidos.add( "     "+ID.toString() + "                 "+tipoAero + "             "+ date);
            }

        }



        //Creamos el adaptador
        //Y se lo introdiccimos al listView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pedidos);

        listView.setAdapter(adapter);


    }
    public void onClickVolver (View view) {
        //Creamos la intencion
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}