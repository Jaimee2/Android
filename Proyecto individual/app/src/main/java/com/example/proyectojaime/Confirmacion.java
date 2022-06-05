package com.example.proyectojaime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.SharedPreferencesCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.proyectojaime.Modelos.OrdenFabricacion;
import com.example.proyectojaime.Modelos.Palas;


import java.util.Date;

public class Confirmacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);

        //Solo mostramos mensaje de confirmación para indicar que se ha finalizado
    }

    public void clickConfirmar(View view){
        Intent intent = new Intent(getApplicationContext(),ListadoFabricacion.class);
        startActivity(intent);
    }

    public void onClickInicio(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }



}