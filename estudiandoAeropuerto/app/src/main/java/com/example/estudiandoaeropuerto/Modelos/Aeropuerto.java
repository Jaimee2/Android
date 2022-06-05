package com.example.estudiandoaeropuerto.Modelos;

import java.util.List;

public class Aeropuerto {
    private String nombreAeropuerto;
    private String codigo;
    private List<Destino> destinos;

    public Aeropuerto(){
    }

    public Aeropuerto(String nombreAeropuerto, String codigo, List<Destino> destinos) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.codigo = codigo;
        this.destinos = destinos;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Destino> getDestinos() {
        return destinos;
    }

    public void setDestinos(List<Destino> destinos) {
        this.destinos = destinos;
    }

    @Override
    public String toString() {
        return nombreAeropuerto + "-"+codigo;
    }
}
