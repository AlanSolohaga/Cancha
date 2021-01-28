package com.project.cancha.model;

import com.project.cancha.interfaz.IEquiposInteractor;
import com.project.cancha.interfaz.IPresentEquipos;
import com.project.cancha.present.PresentEquipos;

public class EquiposInteractor implements IEquiposInteractor {

    private IPresentEquipos presentador;

    public EquiposInteractor(IPresentEquipos presentador) {
        this.presentador = presentador;
    }
}
