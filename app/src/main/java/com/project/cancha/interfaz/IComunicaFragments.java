package com.project.cancha.interfaz;

import android.view.View;

import com.project.cancha.model.Equipo;
import com.project.cancha.model.Jugador;

import java.util.ArrayList;

public interface IComunicaFragments {
    void mostrarFragment(int id);
    void mostrarTurnos(int id);
    void llevarEquipos(ArrayList<Jugador> equipo1, ArrayList<Jugador> equipo2);
}
