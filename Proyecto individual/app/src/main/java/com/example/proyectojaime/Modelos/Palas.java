package com.example.proyectojaime.Modelos;

import java.io.Serializable;
//se implementa la clase Serializable para poder pasar el objeto con el metodo bundle
public class Palas implements Serializable {

    //Atributos
    int ID;
    public String tipoAerogenerador;
    public int potencia;//1. baja 2. media 3. alta
    public int numPalas;//1. unipala 2. bipala 3. tripala

    //Constructor
    public Palas(){}

    //Metodos Setters
    public void setTipoAerogenerador(String tipoAerogenerador){this.tipoAerogenerador = tipoAerogenerador;}

    public void setPotencia(int potencia){this.potencia = potencia;}

    public void setNumPalas(int numPalas){this.numPalas = numPalas;}

    public void setID(int ID){this.ID = ID;}

    //Metodos Getters

    public String getTipoAerogenerador(){return tipoAerogenerador;}

    public int getPotencia(){return potencia;}

    public int getNumPalas(){return numPalas;}

    public int getID(){return ID;}

}
