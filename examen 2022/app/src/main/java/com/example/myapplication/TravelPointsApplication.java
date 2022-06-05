package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.Modelos.Consumo;
import com.example.myapplication.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class
TravelPointsApplication extends Application {

    public  static List<Producto> ListaProductos = new ArrayList<>();
    public  static List<Consumo> ListaConsumos = new ArrayList<>();


    @Override
    public void onCreate() {
        super.onCreate();
    }




}