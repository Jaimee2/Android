package com.example.myapplication.Modelos;

import java.io.Serializable;

public class Producto implements Serializable {
    //se implementa la clase Serializable para poder pasar el objeto con el metodo bundle
    //Atributos
    String nombre;
    int precio;

    //Contructor
    public Producto(){}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setPrecio(int precio){this.precio = precio;}
    public String getNombre(){return nombre;}
    public int getPrecio(){return precio;}

}
