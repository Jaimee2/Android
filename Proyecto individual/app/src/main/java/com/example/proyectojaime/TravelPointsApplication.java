package com.example.proyectojaime;

import android.app.Application;

import com.example.proyectojaime.Modelos.OrdenFabricacion;
import com.example.proyectojaime.Modelos.Palas;

import java.util.ArrayList;
import java.util.List;

public class
TravelPointsApplication extends Application {

    public static int contador = 1;//Lo utilizo para no repetir IDs

    public  static List<OrdenFabricacion> ListaOrdenFabricacion = new ArrayList<>();
    public  static List<Palas> ListaPalas = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }




}
