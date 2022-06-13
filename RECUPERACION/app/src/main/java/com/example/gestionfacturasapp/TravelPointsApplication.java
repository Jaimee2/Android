package com.example.gestionfacturasapp;

import android.app.Application;

import com.example.gestionfacturasapp.Modelos.Articulo;
import com.example.gestionfacturasapp.Modelos.Factura;

import java.util.ArrayList;
import java.util.List;

public class TravelPointsApplication extends Application {

    public static List<Articulo> ListArticulos = new ArrayList<>();
    public static List<Factura> ListFacturas = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();


    }
}




