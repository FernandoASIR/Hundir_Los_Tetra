/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @authot:Johana Pardo;
 * @version:21-03-2023
 * */
package com.funciones;

/**
 * La clase Cuadrado representa un tetramino que tiene la forma de cuatro en linea.
 * Extiende la clase Tetramino y se utiliza para representar dicho tetramino en el tablero del juego.
 */
public class Linea4 extends Tetramino {
    //Nombre por defecto de los objetos de esta clase
    private static final String NOMBRE_POR_DEFECTO = "Linea";
    /**
     * Crea un nuevo objeto Linea4 en la posición especificada.
     *
     * @param posicionX la posición X del tetramino en el tablero
     * @param posicionY la posición Y del tetramino en el tablero
     */

    public Linea4(int posicionX, int posicionY) {

        super(NOMBRE_POR_DEFECTO, posicionX, posicionY);

    }
    /**
     * Construye el tetramino en la dirección norte a partir de la posición especificada.
     *
     * @param posicionX la posición X del tetramino en el tablero
     * @param posicionY la posición Y del tetramino en el tablero
     * @param tablero   el tablero en el que se construye el tetramino
     */
    @Override
    public void construirNorte(int posicionX, int posicionY, Tablero tablero) {
        //Variables internas para no actuar sobre las originales
        int nextX = posicionX;
        int nextY = posicionY;
        // Comprueba si las casillas necesarias están disponibles
        if (comprobarLimite(nextX, nextY) && tablero.comprobarCasilla(nextX, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX - 1, nextY) && tablero.comprobarCasilla(nextX - 1, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX - 2, nextY) && tablero.comprobarCasilla(nextX - 2, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX - 3, nextY) && tablero.comprobarCasilla(nextX - 3, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        nextX = posicionX;
        nextY = posicionY;
        // Coloca el tetramino si todas las casillas necesarias están disponibles
        if (contadorOK == PUNTOS_DE_VIDA) {
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX - 1, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX - 2, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX - 3, nextY, Estado.OCUPADO);
            //Cambia su atributo a true para verificar su correcta colocacion en el tablero
            setColocado(true);
        }
        //Vuelve a poner a cero el contador para poder volver a usarlo
        contadorOK = 0;
    }
    /**
     * Construye el tetramino en la dirección sur a partir de la posición especificada.
     *
     * @param posicionX la posición X del tetramino en el tablero
     * @param posicionY la posición Y del tetramino en el tablero
     * @param tablero   el tablero en el que se construye el tetramino
     */
    @Override
    public void construirSur(int posicionX, int posicionY, Tablero tablero) {
        //Variables internas para no actuar sobre las originales
        int nextX = posicionX;
        int nextY = posicionY;
        // Comprueba si las casillas necesarias están disponibles
        if (comprobarLimite(nextX, nextY) && tablero.comprobarCasilla(nextX, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX +1, nextY) && tablero.comprobarCasilla(nextX + 1, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX +2, nextY) && tablero.comprobarCasilla(nextX + 2, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX + 3, nextY) && tablero.comprobarCasilla(nextX + 3, nextY, Estado.AGUA)) {
            contadorOK++;
        }

        // Coloca el tetramino si todas las casillas necesarias están disponibles
        if (contadorOK == PUNTOS_DE_VIDA) {
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX + 1, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX + 2, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX + 3, nextY, Estado.OCUPADO);
            //Cambia su atributo a true para verificar su correcta colocacion en el tablero
            setColocado(true);
        }
        //Vuelve a poner a cero el contador para poder volver a usarlo
        contadorOK = 0;
    }
    /**
     * Construye el tetramino en la dirección este a partir de la posición especificada.
     *
     * @param posicionX la posición X del tetramino en el tablero
     * @param posicionY la posición Y del tetramino en el tablero
     * @param tablero   el tablero en el que se construye el tetramino
     */
    @Override
    public void construirEste(int posicionX, int posicionY, Tablero tablero) {
        //Variables internas para no actuar sobre las originales
        int nextX = posicionX;
        int nextY = posicionY;
        // Comprueba si las casillas necesarias están disponibles
        if (comprobarLimite(nextX, nextY) && tablero.comprobarCasilla(nextX, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY+1) && tablero.comprobarCasilla(nextX , nextY+1, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY+2) && tablero.comprobarCasilla(nextX, nextY+2, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY+3) && tablero.comprobarCasilla(nextX , nextY+3, Estado.AGUA)) {
            contadorOK++;
        }

        // Coloca el tetramino si todas las casillas necesarias están disponibles
        if (contadorOK == PUNTOS_DE_VIDA) {
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY+1, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY+2, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY+3, Estado.OCUPADO);
            //Cambia su atributo a true para verificar su correcta colocacion en el tablero
            setColocado(true);
        }
        //Vuelve a poner a cero el contador para poder volver a usarlo
        contadorOK = 0;
    }
    /**
     * Construye el tetramino en la dirección oeste a partir de la posición especificada.
     *
     * @param posicionX la posición X del tetramino en el tablero
     * @param posicionY la posición Y del tetramino en el tablero
     * @param tablero   el tablero en el que se construye el tetramino
     */

    @Override
    public void construirOeste(int posicionX, int posicionY, Tablero tablero) {
        //Variables internas para no actuar sobre las originales
        int nextX = posicionX;
        int nextY = posicionY;
        // Comprueba si las casillas necesarias están disponibles
        if (comprobarLimite(nextX, nextY) && tablero.comprobarCasilla(nextX, nextY, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY-1) && tablero.comprobarCasilla(nextX , nextY-1, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY-2) && tablero.comprobarCasilla(nextX , nextY-2, Estado.AGUA)) {
            contadorOK++;
        }
        if (comprobarLimite(nextX , nextY-3) && tablero.comprobarCasilla(nextX , nextY-3, Estado.AGUA)) {
            contadorOK++;
        }
        // Coloca el tetramino si todas las casillas necesarias están disponibles
        if (contadorOK == PUNTOS_DE_VIDA) {
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX, nextY, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY-1, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY-2, Estado.OCUPADO);
            tablero.colocarTetramino(tablero, NOMBRE_POR_DEFECTO, nextX , nextY-3, Estado.OCUPADO);
            //Cambia su atributo a true para verificar su correcta colocacion en el tablero
            setColocado(true);
        }
        //Vuelve a poner a cero el contador para poder volver a usarlo
        contadorOK = 0;
    }
}
