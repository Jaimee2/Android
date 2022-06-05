package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TravelPointsApplication tpa;
    ListView listMain;
    public ArrayList<String> ListaConsumiciones;
    int precioTotal;
    TextView textoPrecioTotal,textoPrecioComensal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Casting tpa
        tpa = (TravelPointsApplication)getApplicationContext();
        //Casting de la listView principal
        listMain = findViewById(R.id.listMain);

        //Variables auxiliares para el listado
        ListaConsumiciones = new ArrayList<>();
        String nombre;
        int precio;
        int cantidad;
        precioTotal = 0;
        for (int i=0;i<tpa.ListaConsumos.size();i++) {

            nombre = tpa.ListaConsumos.get(i).getNombre();
            precio = tpa.ListaConsumos.get(i).getPrecio();
            cantidad = tpa.ListaConsumos.get(i).getCantidad();
            precioTotal += precio * cantidad;

            ListaConsumiciones.add(nombre+"    " +"("+ precio +  "  eur )" + " x " + cantidad);
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,ListaConsumiciones);

        listMain.setAdapter(adapter);

        //casting
        textoPrecioTotal = (TextView) findViewById(R.id.textView2);
        textoPrecioTotal.setText(Integer.toString(precioTotal) + "eur");

        //Casting
        EditText comensales = (EditText) findViewById(R.id.editTextTextPersonName4);

        comensales.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                try {
                    int numComensales = Integer.valueOf(comensales.getText().toString());
                    //Casting
                    textoPrecioComensal = (TextView) findViewById(R.id.textView3);
                    textoPrecioComensal.setText(Integer.toString((precioTotal/numComensales)));
                    //Toast.makeText(MainActivity.this,"Hola" , Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    //Toast.makeText(MainActivity.this,"F" , Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    int numComensales = Integer.valueOf(comensales.getText().toString());
                    //Casting
                    textoPrecioComensal = (TextView) findViewById(R.id.textView3);
                    textoPrecioComensal.setText(Integer.toString((precioTotal/numComensales)));
                    //Toast.makeText(MainActivity.this,"Hola" , Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    //Toast.makeText(MainActivity.this,"F" , Toast.LENGTH_SHORT).show();
                }


            }
        });










        //Ir a PRoductosActivity
        FloatingActionButton myFab = (FloatingActionButton)findViewById(R.id.floatingActionButton);

        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ConsumicionActivity.class);
                startActivity(intent);
            }
        });



    }

    //Ir a PRoductosActivity
    public void irPRoductosActivity(View view){
        Intent intent = new Intent(getApplicationContext(),ProductosActivity.class);
        startActivity(intent);
    }



}