package com.example.proyectojaime.Modelos;

import java.io.Serializable;
import java.util.Date;

public class OrdenFabricacion implements Serializable {

    int ID;
    String tipoAerogenerador;
    String fechaProgramada;
    Boolean urgencia = false;
    //Constructor
    public OrdenFabricacion(int ID,String tipoAerogenerador, String fechaProgramada){
        this.ID = ID;
        this.tipoAerogenerador = tipoAerogenerador;
        this.fechaProgramada = fechaProgramada;
    }

    //Setter and Getter
    public void setUrgencia(){this.urgencia = true;}

    public int getID(){return this.ID;}

    public String getTipoAerogenerador(){return this.tipoAerogenerador;}

    public String getFechaProgramada(){return this.fechaProgramada;}

    public Boolean getUrgencia(){return this.urgencia;}




}
