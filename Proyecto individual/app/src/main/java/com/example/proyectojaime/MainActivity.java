package com.example.proyectojaime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.proyectojaime.Modelos.Palas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListViewAdapter listViewAdapter;

    String[] titulos = new String[]{
            "Aerogenerador eje Horizontal",
            "Aerogenerador eje Vertical",
            "Aerogenerador marino"
    };
    int[] imagenes = {
            R.drawable.ic_horizontal,
            R.drawable.ic_vertical,
            R.drawable.ic_marino
    };


    TravelPointsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos el objeto Palas
        Palas palas = new Palas();

        try {
            tpa = (TravelPointsApplication)getApplicationContext();
        } catch(Exception e) {
            Toast.makeText(getApplicationContext(),"Salta el try" ,Toast.LENGTH_SHORT).show();
        }

        ListView lista = (ListView) findViewById(R.id.Lista2);
        listViewAdapter = new ListViewAdapter(this,titulos,imagenes);
        lista.setAdapter(listViewAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                Intent intent = new Intent(getApplicationContext(),Configuracion.class);

                switch (posicion){
                    case 0:
                        //Mostramos seleccion
                        //Toast.makeText(MainActivity.this,"A. eje Horizontal" ,Toast.LENGTH_SHORT).show();
                        palas.setTipoAerogenerador("A. eje Horizontal");
                        intent.putExtra("palas", palas);
                        //Iniciamos la actividad
                        startActivity(intent);
                        break;
                    case 1:
                        //Mostramos seleccion
                        //Toast.makeText(getApplicationContext(),"A. eje Vertical" ,Toast.LENGTH_SHORT).show();
                        palas.setTipoAerogenerador("A. eje Vertical     ");
                        intent.putExtra("palas", palas);
                        //Iniciamos la actividad
                        startActivity(intent);
                        break;
                    case 2:
                        //Mostramos seleccion
                        //Toast.makeText(getApplicationContext(),"A. Marino" ,Toast.LENGTH_SHORT).show();


                        palas.setTipoAerogenerador("A. Marino             ");
                        intent.putExtra("palas", palas);
                        //Iniciamos la actividad
                        startActivity(intent);
                        break;

                }
            }
        });

    }

    public void onClickFabricacion(View view){
        Intent intent = new Intent(getApplicationContext(),ListadoFabricacion.class);
        startActivity(intent);
    }

    public void onClickPalas(View view){
        Intent intent = new Intent(getApplicationContext(),ListadoPalas.class);
        startActivity(intent);
    }
}