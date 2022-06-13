package com.example.gestionfacturasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionfacturasapp.Modelos.Articulo;

import java.util.ArrayList;
import java.util.List;

public class DeudasActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;
    private int ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deudasactivity);

        //Que id de factura entra
        Intent intent = getIntent();
        ID = intent.getExtras().getInt("ID");

        List<Articulo> articulos =  tpa.ListFacturas.get(ID).getArticulos();

        //Casting de la lista
        //Lista main
        ListView listaDeudas = findViewById(R.id.ListaDeudas);

        /*
        * NO ME HA DADO TIEMPO A TERMINARLO
        * YO LO QUE HARÍA SERÍA CREAR UN MAPS DONDE SE GUARDE EL
        * NOMBRE DE LOS DEUDORES
        * Y A CADA DEUDOR LE VOY SUMANDO LA CANTIDAD QUE DEBE
        * POR ÚLTIMO MOSTRARIA CADA DEUDOR Y SU CANTIDAD*/






    }

    //Ir a Main
    public void irMain_dedeDeudas(View view){

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //Nos vamos a la factura que ha entrado
        intent.putExtra("ID",ID);
        startActivity(intent);
    }
}
