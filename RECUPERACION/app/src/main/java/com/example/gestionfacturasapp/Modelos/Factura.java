package com.example.gestionfacturasapp.Modelos;

import java.util.List;

public class Factura {
    private int id;
    private List<Articulo> articulos;

    public Factura (){

    }

    public  Factura(int id, List<Articulo> articulos){
        this.id = id;
        this.articulos = articulos;
    }

    //Setters

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void setId(int id) {
        this.id = id;
    }
    //getters


    public int getId() {
        return id;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    @Override
    public String toString() {
        return "Factura " + id;
    }
}
