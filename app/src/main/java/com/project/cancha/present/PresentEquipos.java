package com.project.cancha.present;

import com.project.cancha.interfaz.IEquiposInteractor;
import com.project.cancha.interfaz.IEquiposVista;
import com.project.cancha.interfaz.IPresentEquipos;
import com.project.cancha.model.EquiposInteractor;
import com.project.cancha.vista.EquiposFragment;

public class PresentEquipos implements IPresentEquipos {
    IEquiposVista vista;
    IEquiposInteractor interactor;

    public PresentEquipos(IEquiposVista vista) {
        this.vista = vista;
        this.interactor = new EquiposInteractor(this);
    }
}
