package com.funciones;

/**
 * Enumeración que define los estados posibles de una casilla en el juego.
 * AGUA representa una casilla vacía sin barco.
 * TOCADO representa una casilla con un barco que ha sido atacada.
 * FALLASTE representa una casilla sin barco que ha sido atacada.
 * OCUPADO representa una casilla que contiene un barco sin ser atacado.
 */


public enum Estado {
    AGUA,
    TOCADO,
    FALLASTE,
    OCUPADO
}
