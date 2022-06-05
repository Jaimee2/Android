package com.example.myapplication.Modelos;

public class Destino {
    //Atributos
    private String nombreDestino;
    private int distanciaOrigen;
    //private List<HorariosSalida> horariosSalidaList;

    public Destino(){
    }

    public Destino(String nombreDestino, int distanciaOrigen){
        this.nombreDestino = nombreDestino;
        this.distanciaOrigen = distanciaOrigen;
        //
    }

    //Setters

    public void setDistanciaOrigen(int distanciaOrigen) {
        this.distanciaOrigen = distanciaOrigen;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    //Getters


    public int getDistanciaOrigen() {
        return distanciaOrigen;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    @Override
    public String toString() {
        return "Destinos{" +
                "nombreDestino='" + nombreDestino + '\'' +
                ", distanciaOrigen=" + distanciaOrigen +
                '}';
    }
}
