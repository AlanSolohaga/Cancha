package com.project.cancha.model;

public enum NivelJugador {
    MALO(1),
    BUENO(2),
    EXCELENTE(3);

    private int calidadNum;

    NivelJugador(int calidadNum) {
        this.calidadNum = calidadNum;
    }

    public int getCalidadNum() {
        return calidadNum;
    }

    public void setCalidadNum(int calidadNum) {
        this.calidadNum = calidadNum;
    }
}
