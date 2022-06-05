package com.example.estudiandoaeropuerto.Modelos;

import java.util.List;

public class Destino {
    private String nombreDestino;
    private int distanciaOrigen;
    private List<HorarioSalida> horarios;

    public Destino() {
    }

    public Destino(String nombreDestino, int distanciaOrigen, List<HorarioSalida> horarios) {
        this.nombreDestino = nombreDestino;
        this.distanciaOrigen = distanciaOrigen;
        this.horarios = horarios;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public int getDistanciaOrigen() {
        return distanciaOrigen;
    }

    public void setDistanciaOrigen(int distanciaOrigen) {
        this.distanciaOrigen = distanciaOrigen;
    }

    public List<HorarioSalida> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioSalida> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return nombreDestino + '-' + distanciaOrigen + '-' + horarios;
    }
}
