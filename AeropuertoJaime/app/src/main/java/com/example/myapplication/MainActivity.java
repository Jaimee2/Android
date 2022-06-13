package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.Modelos.Aeropuerto;
import com.example.myapplication.Modelos.Destino;
import com.example.myapplication.Modelos.HorarioSalida;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<Aeropuerto> adapter;
    private TravelPointsApplication tpa;
    private  ListView listMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //casting tpa
        tpa = (TravelPointsApplication) getApplicationContext();

        //Si no hay nada en la lista le insertamos los valores por defecto
        if(tpa.ListAeropuertos.size() == 0){

            inicializarListaAeropuertos(tpa.ListAeropuertos);

        }

        //Casting de la listView principal
        listMain = findViewById(R.id.ListaMain);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tpa.ListAeropuertos);

        try {
            listMain.setAdapter(adapter);
        }catch (Exception e){}


        listMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DestinosActivity.class);
                //posicion del aeropuerto
                intent.putExtra("posicion",position);
                startActivity(intent);
            }
        });

        //Casting float buton
        FloatingActionButton botonFlotante = findViewById(R.id.floatingActionButton);

        botonFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Cuado sea pulsado nos vamos a crear un nuevo aeropuerto
                Intent intent = new Intent(getApplicationContext(), NuevoAeropuertoActivity.class);
                startActivity(intent);
            }
        });
    }

    public void inicializarListaAeropuertos(List<Aeropuerto> List_Aeropuertos){
        HorarioSalida horarioSalida = new HorarioSalida("12:00","120");
        List<HorarioSalida> listHS = new ArrayList<>();
        listHS.add(horarioSalida);

        Destino destino = new Destino("Barcelona",300,listHS);
        List<Destino> listaDestinos= new ArrayList<>();
        listaDestinos.add(destino);

        Aeropuerto aeropuerto1 = new Aeropuerto("Jaén","1111",listaDestinos);
        List_Aeropuertos.add(aeropuerto1);

        /*******************************************************************************************/
        HorarioSalida horarioSalida2 = new HorarioSalida("14:00","10");

        List<HorarioSalida> listHS2 = new ArrayList<>();
        listHS2.add(horarioSalida2);

        Destino destino2 = new Destino("Mallorca",500,listHS2);
        List<Destino> listaDestinos2 = new ArrayList<>();
        listaDestinos2.add(destino2);

        Aeropuerto aeropuerto2 = new Aeropuerto("Madrid","2222",listaDestinos2);
        List_Aeropuertos.add(aeropuerto2);
        Toast.makeText(MainActivity.this,"Longitud: "+ List_Aeropuertos.get(0).getDestinos().size() , Toast.LENGTH_SHORT).show();
        /*******************************************************************************************/

        //Aeropuerto aeropuerto3 = new Aeropuerto("Pamplona","3333",listaDestinos);
        //List_Aeropuertos.add(aeropuerto3);

    }
}