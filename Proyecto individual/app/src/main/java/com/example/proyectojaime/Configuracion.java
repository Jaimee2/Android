package com.example.proyectojaime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.proyectojaime.Modelos.Palas;

public class Configuracion extends AppCompatActivity {

    Bundle bundle;
    Palas palas;
    RadioButton baja, media, alta;
    RadioButton uniPala, biPala, triPala;
    Button presupuesto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        //Llegada de datos de MainActivity
        bundle = getIntent().getExtras();
        palas =(Palas) bundle.getSerializable("palas");

        //Toast.makeText(getApplicationContext(),palas.getTipoAerogenerador(),Toast.LENGTH_SHORT).show();

        //Casting de todos los checkBox
        baja = (RadioButton) findViewById(R.id.radioBaja);
        media = (RadioButton) findViewById(R.id.radioMedia);
        alta = (RadioButton) findViewById(R.id.radioAlta);

        uniPala = (RadioButton) findViewById(R.id.radioUna);
        biPala = (RadioButton) findViewById(R.id.radioDos);
        triPala = (RadioButton) findViewById(R.id.radioTres);

        //Casting del boton de presupuestos

        presupuesto = (Button) findViewById(R.id.buttonPresupuesto);

    }

    //Accion cuando presionamos el boton Presupuesto
    public void onClick (View view){

        //Comprobamos que potencia se ha seleccionado
        if (baja.isChecked()){
            palas.setPotencia(1);
        }else if (media.isChecked()){
            palas.setPotencia(2);
        }else if (alta.isChecked()){
            palas.setPotencia(3);
        }
        //Comprobamos el número de palas seleccionado
        String cadenaN = "Numero de palas: ";
        if (uniPala.isChecked()){
            palas.setNumPalas(1);
        }else if (biPala.isChecked()){
            palas.setNumPalas(2);
        }else if (triPala.isChecked()){
            palas.setNumPalas(3);
        }

        if((baja.isChecked() || media.isChecked()|| alta.isChecked()) && (uniPala.isChecked() || biPala.isChecked() || triPala.isChecked())){
            //Madamos el bundle con el objeto palas
            Intent intent = new Intent(getApplicationContext(),Presupuesto.class);
            intent.putExtra("palas", palas);
            startActivity(intent);
        }else {
            Toast.makeText(getApplicationContext(),"Error! Complete todos los campos.",Toast.LENGTH_SHORT).show();
        }

    }




}