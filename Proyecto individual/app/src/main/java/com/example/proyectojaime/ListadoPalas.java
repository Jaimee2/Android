package com.example.proyectojaime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.proyectojaime.Modelos.OrdenFabricacion;

import java.util.ArrayList;

public class ListadoPalas extends AppCompatActivity {


    public ListView listView;
    public ArrayList<String> listarPalas;
    TravelPointsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_palas);

        //Casting de la listView principal
        listView = findViewById(R.id.lista3);
        //
        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();

        //Variables auxiliares para el listado
        listarPalas = new ArrayList<>();
        String tipo;
        int potencia;
        int numPalas;
        int ID;

        for (int i=0;i<tpa.ListaPalas.size();i++) {

            ID = tpa.ListaPalas.get(i).getID();
            tipo = tpa.ListaPalas.get(i).getTipoAerogenerador();
            potencia = tpa.ListaPalas.get(i).getPotencia();
            numPalas = tpa.ListaPalas.get(i).getNumPalas();

            if(potencia == 1){
                listarPalas.add("  "+ID  +"        "+tipo + "          "+"500   KW"+ "                         "+ numPalas);
            }else if(potencia == 2){
                listarPalas.add("  "+ID  +"        "+tipo + "          "+"1000 KW"+ "                         "+ numPalas);
            }else if(potencia == 3){
                listarPalas.add("  "+ID +"        "+tipo + "          "+"1500 KW"+ "                         "+ numPalas);
            }





        }

        //Creamos el adaptador
        //Y se lo introdiccimos al listView
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listarPalas);

        listView.setAdapter(adapter);


    }

    public void onClick(View view) {
        //Creamos la intencion
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}