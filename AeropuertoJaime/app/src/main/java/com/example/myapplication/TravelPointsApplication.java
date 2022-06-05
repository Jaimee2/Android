package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.Modelos.Aeropuerto;

import java.util.ArrayList;
import java.util.List;

public class TravelPointsApplication extends Application {

    public  static List<Aeropuerto> ListAeropuertos = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }




}