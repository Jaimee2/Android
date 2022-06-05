package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Modelos.Producto;


public class NuevoProductoActivity extends AppCompatActivity {

    TravelPointsApplication tpa;
    EditText nombreText,precioText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevoproductoactivity);


    }

    //Ir a PRoductosActivity //Volvemos atras
    public void irPRoductosActivity(View view){
        Intent intent = new Intent(getApplicationContext(),ProductosActivity.class);
        startActivity(intent);
    }

    //Ir a PRoductosActivity //Volvemos atras
    public void irPRoductosActivity_Aceptar(View view){

        //Creamos el objeto producto
        Producto producto = new Producto();
        //
        tpa = (TravelPointsApplication)getApplicationContext();
        //Obtenemos el nombre del producto
        nombreText = (EditText) findViewById(R.id.editTextTextPersonName);
        precioText = (EditText) findViewById(R.id.editTextTextPersonName2);
        int precio = Integer.valueOf(precioText.getText().toString());
        producto.setNombre(nombreText.getText().toString());
        producto.setPrecio(precio);
        //Añadimos el producto a la lista
        tpa.ListaProductos.add(producto);

        Intent intent = new Intent(getApplicationContext(),ProductosActivity.class);
        startActivity(intent);
    }

}
