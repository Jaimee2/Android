package com.example.myapplication.Modelos;

import java.io.Serializable;

public class Consumo implements Serializable {

    String nombre;
    int precio;
    int cantidad;

    public Consumo(){}

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setPrecio(int precio){this.precio = precio;}
    public String getNombre(){return nombre;}
    public int getPrecio(){return precio;}
    public void setCantidad(int cantidad){this.cantidad = cantidad;}
    public int getCantidad(){return cantidad;}

}
