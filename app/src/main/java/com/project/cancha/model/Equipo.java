package com.project.cancha.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Equipo implements Parcelable {
    private String nombre;
    private ArrayList<Jugador> jugadores;

    public Equipo(String nombre, ArrayList<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    protected Equipo(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<Equipo> CREATOR = new Creator<Equipo>() {
        @Override
        public Equipo createFromParcel(Parcel in) {
            return new Equipo(in);
        }

        @Override
        public Equipo[] newArray(int size) {
            return new Equipo[size];
        }
    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
    }
}
