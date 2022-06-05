package com.example.proyectojaime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectojaime.Modelos.OrdenFabricacion;
import com.example.proyectojaime.Modelos.Palas;

public class SeleccionFecha extends AppCompatActivity {

    TextView textoFecha;
    CalendarView calendario;
    Bundle bundle;
    Palas palas;
    String fecha;
    CheckBox checkBox;

    TravelPointsApplication tpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_fecha);

        //Recivimos el modelo palas
        bundle = getIntent().getExtras();
        palas =(Palas) bundle.getSerializable("palas");
        //Casting del textView
        textoFecha = (TextView) findViewById(R.id.editTextMostrarFecha);

        //Casting del checkBox
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        //Casting del calendario
        calendario = (CalendarView) findViewById(R.id.calendarView);


        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {

                String dias = Integer.toString(day) ;
                String mes = Integer.toString(month + 1);
                String ano = Integer.toString(year) ;

                fecha = '"' + dias + "/" + mes + "/" + ano + '"';
                //Mostramos la fecha a producir
                textoFecha.setText(fecha);

            }
        });
    }


    //Accion cuando presionamos el boton Presupuesto
    public void onClickDescartar (View view) {
        //Creamos la intencion
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

    public void onClickConfirmarFecha(View view){
        if(fecha != null){
            Intent intent = new Intent(getApplicationContext(),Confirmacion.class);

            //V2
            //Casting tpa
            tpa = (TravelPointsApplication)getApplicationContext();

            int ID = tpa.contador;
            //Incrementamos el contador
            tpa.contador++;

            //Objeto ordenFabricacion
            OrdenFabricacion ordenFabricacion = new OrdenFabricacion(ID,palas.getTipoAerogenerador(),fecha);

            //Asignamos el ID al objeto palas también para obtener la relación entre los objetos

            palas.setID(ID);

            //Si esta seleccionada la casilla de urgencia
            if (checkBox.isChecked()){
                ordenFabricacion.setUrgencia();
            }


            //Añado el objeto a la lista de tpa
            tpa.ListaOrdenFabricacion.add(ordenFabricacion);

            //Añadimos el objeto palas a la lista
            tpa.ListaPalas.add(palas);

            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(),"Error! Seleccione una fecha." ,Toast.LENGTH_SHORT).show();
        }

    }


}