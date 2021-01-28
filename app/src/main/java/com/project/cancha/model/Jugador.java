package com.project.cancha.model;

import android.os.Parcel;

public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private NivelJugador nivelJugador;

    public Jugador(String nombre, NivelJugador nivelJugador) {
        this.nombre = nombre;
        this.nivelJugador = nivelJugador;
    }

    protected Jugador(Parcel in) {
        nombre = in.readString();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NivelJugador getNivelJugador() {
        return nivelJugador;
    }

    public void setNivelJugador(NivelJugador nivelJugador) {
        this.nivelJugador = nivelJugador;
    }

    @Override
    public int compareTo(Jugador j) {
        if(j.getNivelJugador().getCalidadNum()>nivelJugador.getCalidadNum()) {
            return -1;
        }else if(j.getNivelJugador().getCalidadNum()>nivelJugador.getCalidadNum()) {
            return 1;
        }else {
            return 0;
        }
    }
}
