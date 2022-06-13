package com.example.myapplication.Modelos;

import java.util.List;

public class Destino {
    //Atributos
    private String nombreDestino;
    private int distanciaOrigen;
    private List<HorarioSalida> horariosSalidaList;

    public Destino(){
    }

    public Destino(String nombreDestino, int distanciaOrigen,List<HorarioSalida> horariosSalidaList){
        this.nombreDestino = nombreDestino;
        this.distanciaOrigen = distanciaOrigen;
        this.horariosSalidaList = horariosSalidaList;
    }

    //Setters

    public void setDistanciaOrigen(int distanciaOrigen) {
        this.distanciaOrigen = distanciaOrigen;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public void setHorariosSalidaList(List<HorarioSalida> horariosSalidaList) {
        this.horariosSalidaList = horariosSalidaList;
    }

    //Getters


    public int getDistanciaOrigen() {
        return distanciaOrigen;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public List<HorarioSalida> getHorariosSalidaList() {
        return horariosSalidaList;
    }

    @Override
    public String toString() {
        return "Destinos{" +
                "nombreDestino='" + nombreDestino + '\'' +
                ", distanciaOrigen=" + distanciaOrigen +
                '}';
    }
}
