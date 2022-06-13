package com.example.gestionfacturasapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gestionfacturasapp.Modelos.Articulo;
import com.example.gestionfacturasapp.Modelos.Factura;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaMain;
    private TravelPointsApplication tpa;
    private  ArrayAdapter<Articulo> adapter;
    private int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Boton flotante
        FloatingActionButton myFab = (FloatingActionButton)findViewById(R.id.floatingActionButton);


        //Lista main
        listaMain = findViewById(R.id.ListaMain);

        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();

        //Si no hay facturas inicializo una
        if(tpa.ListFacturas.size() == 0){
            ID = 0;
            inicioFacturas(tpa.ListFacturas);
            adapter =
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tpa.ListFacturas.get(0).getArticulos());
            listaMain.setAdapter(adapter);
        }else{
            //Obtenemos el id de la factura que ha isertado el intent
            Intent intent = getIntent();
            ID = intent.getExtras().getInt("ID");
            Toast.makeText(this,"ID de la factura: " + ID , Toast.LENGTH_SHORT).show();
            adapter =
                    new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tpa.ListFacturas.get(ID).getArticulos());
            listaMain.setAdapter(adapter);
        }








        //Ir a NuevosArticulosActivity
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),NuevosArticulosActivity.class);
                intent.putExtra("ID",ID);
                startActivity(intent);
            }
        });
    }

    public void inicioFacturas(List<Factura> lista_facturas){
        //Creo artuculos y se lo asigno a una facura
        Articulo articulo1 = new Articulo("Ordenador Portatil",1200,"Unai");
        Articulo articulo2 = new Articulo("Table",500,"Oscar");
        Articulo articulo3 = new Articulo("Raton inalambrico",65,"Unai");
        //Creo una lista de articulos
        List<Articulo> listArticulos = new ArrayList<>();

        listArticulos.add(articulo1);
        listArticulos.add(articulo2);
        listArticulos.add(articulo3);

        //Creamos el objeto faturas con id 0
        Factura factura1 = new Factura(0,listArticulos);
        Factura factura2 = new Factura(1,listArticulos);
        Factura factura3 = new Factura(2,listArticulos);

        //Se la añado a tpa la factura

        lista_facturas.add(factura1);
        lista_facturas.add(factura2);
        lista_facturas.add(factura3);

    }


    //Ir a Historial Facturas
    public void irHistorialFacturas(View view){
        Intent intent = new Intent(getApplicationContext(),HistorialActivity.class);
        //Le envio en que factura estamos por si le da al boton de volver que vuelva a la misma factura
        intent.putExtra("ID",ID);
        startActivity(intent);
    }

    //Ir a Deudas
    public void irDeudas(View view){
        Intent intent = new Intent(getApplicationContext(),DeudasActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
    }

    //Boton limpiar
    public void limpiar(View view){
        //Creamos una lista de articulos vacia
        List<Articulo> listArticulos = new ArrayList<>();
        //A la factula que tenemos en pantalla le asignamos la lista vacia
        tpa.ListFacturas.get(ID).setArticulos(listArticulos);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
    }


}