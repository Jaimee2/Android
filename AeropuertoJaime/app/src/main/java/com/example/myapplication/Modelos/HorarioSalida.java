package com.example.myapplication.Modelos;

public class HorarioSalida {
    private String horaSalida;
    private String puertaSalida;

    public  HorarioSalida(){}

    public HorarioSalida(String horaSalida, String puertaSalida){
        this.horaSalida = horaSalida;
        this.puertaSalida = puertaSalida;
    }

    //Setters

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setPuertaSalida(String puertaSalida) {
        this.puertaSalida = puertaSalida;
    }

    //getters

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getPuertaSalida() {
        return puertaSalida;
    }

    @Override
    public String toString() {
        return "HorarioSalida{" +
                "horaSalida='" + horaSalida + '\'' +
                ", puertaSalida='" + puertaSalida + '\'' +
                '}';
    }
}
