package com.example.estudiandoaeropuerto.Modelos;

public class HorarioSalida {
    private String horaSalida;
    private String puertaSalida;

    public HorarioSalida() {
    }

    public HorarioSalida(String horaSalida, String puertaSalida) {
        this.horaSalida = horaSalida;
        this.puertaSalida = puertaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getPuertaSalida() {
        return puertaSalida;
    }

    public void setPuertaSalida(String puertaSalida) {
        this.puertaSalida = puertaSalida;
    }

    @Override
    public String toString() {
        return horaSalida + '-' + puertaSalida;
    }
}
