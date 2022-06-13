package com.example.gestionfacturasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestionfacturasapp.Modelos.Articulo;

import java.util.ArrayList;
import java.util.List;

public class NuevosArticulosActivity extends AppCompatActivity {

    private TravelPointsApplication tpa;
    private int ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevos_articulos_activity);
        //Obtenemos el id de la factura
        Intent intent = getIntent();
        ID = intent.getExtras().getInt("ID");
        Toast.makeText(this,"ID de la factura: " + ID , Toast.LENGTH_SHORT).show();

    }

    //Ir a Main cancelar
    public void irMainCancelar(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        //FALTA AÑADIR EL ID PARA QUE NO DE ERROR SE ME HA OLVIDADO
        startActivity(intent);
    }

    //Si aceptamos añadimos el articulo
    //Ir a Main cancelar
    public void irMainAceptar(View view){

        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();

        //Obtenemos los parametros
        EditText nombre = findViewById(R.id.editTextTextPersonName);
        EditText precio = findViewById(R.id.editTextTextPersonName2);
        EditText deudor = findViewById(R.id.editTextTextPersonName3);

        int precio_int = Integer.valueOf( precio.getText().toString());
        //Creamos el objeto articulo
        Articulo articulo = new Articulo(nombre.getText().toString(),precio_int,deudor.getText().toString());

        //Obtenemos una lista de los aarticulos de la factura
        //ESTA MAL ES ID NO 0--------------------------------------------------------------
        List<Articulo> listArticulos =  tpa.ListFacturas.get(0).getArticulos();
        //le añadimos el articulo
        listArticulos.add(articulo);

        //
        tpa.ListFacturas.get(ID).setArticulos(listArticulos);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.putExtra("ID",ID);
        startActivity(intent);
    }
}