package com.example.gestionfacturasapp.Modelos;

public class Articulo {
    private String nombre;
    private int precio;
    private String deudor;

    //Constructor 1
    public Articulo(){

    }

    //Constructor 2
    public Articulo(String nombre, int precio, String deudor){
        this.nombre = nombre;
        this.precio = precio;
        this.deudor = deudor;
    }

    //Setters


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setDeudor(String deudor) {
        this.deudor = deudor;
    }

    //Getters

    public int getPrecio() {
        return precio;
    }

    public String getDeudor() {
        return deudor;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return deudor  + " debe pagar: " + nombre + " " + "(" + precio + " eur)";
    }
}
