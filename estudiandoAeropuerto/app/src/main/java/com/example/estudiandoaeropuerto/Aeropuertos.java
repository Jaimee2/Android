package com.example.estudiandoaeropuerto;

import android.app.Application;

import com.example.estudiandoaeropuerto.Modelos.Aeropuerto;

import java.util.ArrayList;
import java.util.List;

public class Aeropuertos extends Application {

    public List<Aeropuerto> aeropuertos = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
