/**
 * Clase que representa una casilla del tablero del juego Hundir los tetraminos.
 * La casilla puede estar en estado AGUA ser parte de un barco OCUPADO y albergar el estado de los disparos
 * TOCADO y FALLADO.
 */
/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @author Johana Pardo;
 * @version:21-03-2023
 * */
package com.funciones;

import java.util.Arrays;
import java.util.Objects;

public class Casilla {

    /**
     * Estado actual de la casilla
     */
    private Estado estadoCasilla;

    /**
     * Fila en la que se encuentra la casilla
     */
    private int fila;

    /**
     * Columna en la que se encuentra la casilla
     */
    private int columna;

    /**
     * Alias opcional para identificar la casilla
     */
    private String alias;

    /**
     * Crea una nueva casilla con estado AGUA
     */
    public Casilla() {
    }

    /**
     * Crea una nueva casilla con estado AGUA en la fila y columna especificadas.
     *
     * @param fila    La fila en la que se encuentra la casilla.
     * @param columna La columna en la que se encuentra la casilla.
     */
    public Casilla(int fila, int columna) {
        this.estadoCasilla = Estado.AGUA;
        this.fila = fila;
        this.columna = columna;
    }

    /**
     * Devuelve el estado actual de la casilla.
     */
    public Estado getEstadoCasilla() {
        return estadoCasilla;
    }

    /**
     * Cambia el estado actual de la casilla.
     */
    public void setEstadoCasilla(Estado estadoCasilla) {
        this.estadoCasilla = estadoCasilla;
    }

    /**
     * Devuelve la fila en la que se encuentra la casilla.
     */
    public int getFila() {
        return fila;
    }

    /**
     * Cambia la fila en la que se encuentra la casilla.
     */
    public void setFila(int fila) {
        this.fila = fila;
    }

    /**
     * Devuelve la columna en la que se encuentra la casilla.
     */
    public int getColumna() {
        return columna;
    }

    /**
     * Cambia la columna en la que se encuentra la casilla.
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
     * Devuelve el alias opcional de la casilla.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Cambia el alias opcional de la casilla.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
}
