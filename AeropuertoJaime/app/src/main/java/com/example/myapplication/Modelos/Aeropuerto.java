package com.example.myapplication.Modelos;

import java.util.List;

public class Aeropuerto {
    //Atributos
    private String nombreAeropuerto;
    private String codigo;
    private List<Destino> destinos;

    //Constructor
    public Aeropuerto(){
    }

    //Constructor
    public Aeropuerto(String nombreAeropuerto, String codigo,List<Destino> destinos){
        this.nombreAeropuerto = nombreAeropuerto;
        this.codigo = codigo;
        this.destinos = destinos;

    }

    //Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }

    //Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "nombreAeropuerto='" + nombreAeropuerto + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
