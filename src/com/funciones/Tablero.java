/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @author:Johana Pardo;
 * @version:21.03.2023
 */
package com.funciones;

public class Tablero {
    /*CONSTANTES PARA LOS COLORES*/
    public static final String BLANCO = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROJO = "\033[31m";
    public static final String NARANJA = "\033[33m";
    public static final String VERDE = "\u001B[32m";
    static final int MAXIMO_CASILLA = 10;

/*Crear una clase llamada "Tablero" que representa el tablero de juego de cada
 jugador (uno guardar los barcos propios y otro para guardar los disparos
  efectuados). Esta clase debe contener una matriz bidimensional de objetos
  Casilla de 10x10, un método para inicializar el tablero
  (colocar los barcos de forma automática o pidiendo datos). */


    private Casilla[][] tablero = new Casilla[MAXIMO_CASILLA][MAXIMO_CASILLA];

    /**Función getter que retorna el tablero creado
     * @return tablero: tablero del jugador
     */
    public Casilla[][] getTablero() {
        return tablero;
    }
    /**Función setter que añade el tablero creado al constructor
     * @param tablero: array bidimensional de casillas a rellenar en el momento de crear tablero
     */

    public void setTablero(Casilla[][] tablero) {
        this.tablero = tablero;
    }

/**Función void que, gracias a una matríz bidimensional rellena el tablero de casillas vacías, unicamente inicializadas en estado "Agua"*/
    public void prepararTablero() {
        //Rellenar filas
        for (int x = 0; x < MAXIMO_CASILLA; x++) {
            //Rellenar columnas
            for (int y = 0; y < MAXIMO_CASILLA; y++) {
                Casilla nueva = new Casilla();
                nueva.setFila(x);
                nueva.setColumna(y);
                nueva.setEstadoCasilla(Estado.AGUA);
                tablero[x][y] = nueva;
            }
        }
    }
/**
 * Función que devuelve valor booleano si la casilla se ha comprobado o no
 * @param x: valor de la fila
 * @param y  valor de la columna introducida
 * @param estadoDeseado : el estado que esperamos tener y que comparamos con el estado actual
 * @return boolean: true  si la casilla está en el estado deseado, de lo contrario false*/
    public boolean comprobarCasilla(int x, int y, Estado estadoDeseado) {
        Estado estadoActual = tablero[x][y].getEstadoCasilla();

        if (estadoActual.equals(estadoDeseado)) {
            return true;
        } else
            return false;
    }
/**Función void que imprime el tablero del jugador con los cambios establecidos, una vez generada la matriz base*/
    public void imprimirTableroJugador() {
        System.out.println("  "); // Espacio en blanco para alinear con las letras
        System.out.println(NARANJA + "Tu tablero:  ");
        System.out.print(BLANCO + "· ");
        for (int i = 1; i <= MAXIMO_CASILLA; i++) {
            System.out.print(VERDE + i + "  ");
        }
        System.out.println();

        for (int i = 0; i < MAXIMO_CASILLA; i++) {
            char letra = (char) ('A' + i);
            System.out.print(VERDE + letra + " "); // Letra de la columna
            for (int j = 0; j < MAXIMO_CASILLA; j++) {
                if (comprobarCasilla(i, j, Estado.OCUPADO)) { //Si la casilla esta ocupada por un barco ponemos v en Naranja como el titulo "Tablero del Jugador" para asociarlo a algo bueno
                    System.out.print(NARANJA + "v  ");
                } else if (comprobarCasilla(i, j, Estado.TOCADO)) { //Si nos golpen un barco imprimimos x en rojo como que hemos golpeado
                    System.out.print(ROJO + "o  ");
                } else if (comprobarCasilla(i, j, Estado.AGUA)) { //Si no es ninguna de las otras es AGUA y ponemos ~ en azul porque parece el mar en calma
                    System.out.print(AZUL + "~  ");
                } else if (comprobarCasilla(i, j, Estado.FALLASTE)) { //Si no es ninguna de las otras es AGUA y ponemos *
                    System.out.print(BLANCO + "x  ");
                }
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }

    /**Función void que imprime el tablero de la máquina con los cambios establecidos, una vez generada la matriz base*/
    public void imprimirTableroMaquina() {
        System.out.println("  "); // Espacio en blanco para alinear con las letras
        System.out.println(ROJO + "Tablero del Ordenador:  ");
        System.out.print(BLANCO + "· ");
        for (int i = 1; i <= MAXIMO_CASILLA; i++) {
            System.out.print(VERDE + i + "  ");
        }
        System.out.println();

        for (int i = 0; i < MAXIMO_CASILLA; i++) {
            char letra = (char) ('A' + i);
            System.out.print(VERDE + letra + " "); // Letra de la columna
            for (int j = 0; j < MAXIMO_CASILLA; j++) {
                if (comprobarCasilla(i, j, Estado.TOCADO)) { //Si golpeamos a un barco imprimimos x
                    System.out.print(ROJO + "o  ");
                } else if (comprobarCasilla(i, j, Estado.FALLASTE)) { //Si no es ninguna de las otras es AGUA y ponemos *
                    System.out.print(BLANCO + "x  ");
                } else if (comprobarCasilla(i, j, Estado.AGUA)) { //Si no es ninguna de las otras es AGUA y ponemos *
                    System.out.print(AZUL + "~  ");
                } else if (comprobarCasilla(i, j, Estado.OCUPADO)) { //Si no es ninguna de las otras es AGUA y ponemos *
                    System.out.print(AZUL + "~  ");
                }
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }
/**
 * Función void para cambiar el estado de la casilla
 * @param x: coordenada en fila
 * @param y : coordenada en columna
 * @param estadoCambio: estado a añadir en la casilla  */
    public void cambiarCasilla(Tablero tablero, int x, int y, Estado estadoCambio) {
        tablero.getTablero()[x][y].setEstadoCasilla(estadoCambio);
    }
/** Función void para guardar el alias del tetramino y cambiar el estado de la casilla
 * @param tablero: tablero a modificar según el turno de juego
 * @param nombreTetramino: nombre establecido al tetramino
 * @param x : coordenada en fila
 * param y: coordenada en columna
 * @param estado : estado a cambiar en casilla */
    public void colocarTetramino(Tablero tablero, String nombreTetramino, int x, int y, Estado estado) {
        tablero.getTablero()[x][y].setAlias(nombreTetramino);
        cambiarCasilla(tablero, x, y, estado);

    }
}

