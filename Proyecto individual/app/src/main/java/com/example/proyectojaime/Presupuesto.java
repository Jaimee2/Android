package com.example.proyectojaime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectojaime.Modelos.Palas;

public class Presupuesto extends AppCompatActivity {

    TextView tipo, potencia, numPalas;
    Bundle bundle;
    Palas palas;
    ImageView imagen;
    int[] imagenes = {
            R.drawable.ic_horizontal,
            R.drawable.ic_vertical,
            R.drawable.ic_marino
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presupuesto);

        //Llegada de datos de Configuracion
        bundle = getIntent().getExtras();
        palas =(Palas) bundle.getSerializable("palas");

        //Casting de los TextView que utilizamos para mostrar los datos del modelo palas
        tipo = (TextView) findViewById(R.id.textViewTipoEje);
        potencia = (TextView) findViewById(R.id.textViewPontencia);
        numPalas = (TextView) findViewById(R.id.textViewNumPalas);
        imagen = (ImageView) findViewById(R.id.imageView);


        //Segun el tipo de aerogenerador que llegue ponemos una imagen u otra
        if (palas.getTipoAerogenerador().equalsIgnoreCase("A. eje Horizontal")){
            imagen.setImageResource(imagenes[0]);
        }else if(palas.getTipoAerogenerador().equalsIgnoreCase("A. eje Vertical     ")){
            imagen.setImageResource(imagenes[1]);
        }else if(palas.getTipoAerogenerador().equalsIgnoreCase("A. Marino             ")){
            imagen.setImageResource(imagenes[2]);
        }

        //Mostramos la descripcion
        mostrarDescripcion();
    }

    public void mostrarDescripcion(){

        tipo.setText(palas.getTipoAerogenerador());

        switch (palas.getPotencia()){
            case 1:
                potencia.setText("Baja");
                break;
            case 2:
                potencia.setText("Media");
                break;
            case 3:
                potencia.setText("Alta");
                break;
        }

        switch (palas.getNumPalas()){
            case 1:
                numPalas.setText("UniPala");
                break;
            case 2:
                numPalas.setText("BiPala");
                break;
            case 3:
                numPalas.setText("TriPala");
                break;
        }
    }

    //Accion cuando presionamos el boton Presupuesto
    public void onClick (View view) {
        Intent intent = new Intent(getApplicationContext(),SeleccionFecha.class);
        intent.putExtra("palas", palas);
        startActivity(intent);
    }
}