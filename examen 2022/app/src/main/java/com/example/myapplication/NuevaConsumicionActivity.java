package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.Consumo;

public class NuevaConsumicionActivity extends AppCompatActivity {


    TravelPointsApplication tpa;
    TextView textPrecio,textNombre;
    int posicion;
    String nombre;
    int precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevaconsumicionactivity);

        Bundle bundle = getIntent().getExtras();


        if (bundle != null){
            posicion = bundle.getInt("posicion");
            //Casting tpa
            tpa = (TravelPointsApplication)getApplicationContext();

            //Castig TextView
            //Casting de la listView principal
            textNombre = (TextView) findViewById(R.id.textView6);
            textPrecio = (TextView) findViewById(R.id.textView7);

            nombre = tpa.ListaProductos.get(posicion).getNombre();
            precio = tpa.ListaProductos.get(posicion).getPrecio();

            textNombre.setText(nombre);
            textPrecio.setText(Integer.toString(precio));

        }


    }

    //Ir a main
    public void irBack(View view){
        Intent intent = new Intent(getApplicationContext(),ConsumicionActivity.class);
        startActivity(intent);
    }

    //Ir a main
    public void irMain_Consumicion(View view){

        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();

        //Creamos un objeto consumo
        Consumo consumo = new Consumo();
        consumo.setNombre(nombre);
        consumo.setPrecio(precio);
        //casting de las unidades
        EditText cantidad = (EditText)findViewById(R.id.editTextTextPersonName3);
        consumo.setCantidad(Integer.valueOf(cantidad.getText().toString()));
        tpa.ListaConsumos.add(consumo);



        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
