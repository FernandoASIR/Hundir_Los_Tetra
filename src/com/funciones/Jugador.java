/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @authot:Johana Pardo;
 * @version:21.03.2023
 * */

package com.funciones;

import java.util.Scanner;
import java.util.Random;



public class Jugador {
    /*COLORES*/
    public static final String VERDE = "\u001B[32m";
    //Maximo de tetraminos
    public static final int MAX_TETRAMINOS = 5;
    Scanner scanner = new Scanner(System.in);
    //Nombre del jugador
    private String nombreJugador;
    //Tablero de juego
    private Tablero tablerosJuego;
    //coordenadas introducidas
    private int x;
    private int y;
    //Array con los objetos tetraminos que tiene el jugador
    private Tetramino[] misTetraminos;

    //Vidas totales del jugador
    public int vidasJugador = MAX_TETRAMINOS * Tetramino.PUNTOS_DE_VIDA;

    public Jugador(String nombreJugador, Tablero tablerosJuego) {
        setNombreJugador(nombreJugador);
        this.tablerosJuego = tablerosJuego;
        misTetraminos = new Tetramino[MAX_TETRAMINOS];
        Linea4 linea= new Linea4 (x, y);
        Cuadrado cuadrado = new Cuadrado(x,y);
        Zeta zeta = new Zeta(x, y);
        FormaL formaL = new FormaL(x, y);
        Podio podio = new Podio(x, y);
            misTetraminos[0] = linea;
            misTetraminos[1] = cuadrado;
            misTetraminos[2] = zeta;
            misTetraminos[3] = formaL;
            misTetraminos[4] = podio;
    }

    public Jugador() {
        nombreJugador = "";
        tablerosJuego = new Tablero();
        misTetraminos = new Tetramino[MAX_TETRAMINOS];
        Linea4 linea= new Linea4 (x, y);
        Cuadrado cuadrado = new Cuadrado(x,y);
        Zeta zeta = new Zeta(x, y);
        FormaL formaL = new FormaL(x, y);
        Podio podio = new Podio(x, y);
        misTetraminos[0] = linea;
        misTetraminos[1] = cuadrado;
        misTetraminos[2] = zeta;
        misTetraminos[3] = formaL;
        misTetraminos[4] = podio;


    }
/**
 * Función gett para devolver el nombre del jugador
 * @return  nombre : cadena de texto con nombre del jugador*/
    public String getNombreJugador() {
        return nombreJugador;
    }
/**
 * Función para editar el nombre del jugador
 * @param nombreJugador: cadena de texto con el nombre del jugador*/
    public void setNombreJugador(String nombreJugador) {
        String nombreJugadorCorregido;
        nombreJugadorCorregido = nombreJugador.trim();
        String primerLetraMayuscula = nombreJugadorCorregido.substring(0, 1).toUpperCase();
        String restoMinusculas = nombreJugadorCorregido.substring(1).toLowerCase();
        String textoFormateado = primerLetraMayuscula + restoMinusculas;
        this.nombreJugador = textoFormateado;
    }
/**
 * Función para retornar coordenada
 * @return coordenada: devuelve el valor de x en un entero
 */
    public int getX() {
        return x;
    }
    /**
     * Función para modificar o guardar coordenada
     * @param x: añade el valor entero a la coordenada x del constructor
     */

    public void setX(int x) {
        this.x = x;
    }

    /**
     * Función para retornar coordenada
     * @return coordenada: devuelve el valor de y en un entero
     */

    public int getY() {
        return y;
    }
    /**
     * Función para modificar o guardar coordenada
     * @param y: añade el valor entero a la coordenada y del constructor
     */

    public void setY(int y) {
        this.y = y;
    }

    /**
     * Función devolver el tablero generado
     * @return  tablero: devuelve el tablero generado
     */

    public Tablero getTablerosJuego() {
        return tablerosJuego;
    }

    /**
     * Función para guardar el tablero creado para el jugador
     * @param  tablerosJuego: asigna el tablero creado al objeto jugador
     */
    public void setTablerosJuego(Tablero tablerosJuego) {
        this.tablerosJuego = tablerosJuego;
    }

    /**
     * Función para devolver los tetraminos guardados en el array de misTetraminos
     * @return  misTetraminos: devuelve el array de tetraminos creados
     */
    public Tetramino[] getMisTetraminos() {
        return misTetraminos;
    }
    /**
     * Función para añadir tetraminos al array de objetos tetramino
     * @param  misTetraminos: es el array de tetraminos donde haremos cambios
     */

    public void setMisTetraminos(Tetramino[] misTetraminos) {
        if (misTetraminos.length <= MAX_TETRAMINOS) {
            this.misTetraminos = misTetraminos;
        } else
            System.err.println("No se pueden introducir mas tetraminos");
    }
    /**
     * Función devolver vidas del jugador que estan guardadas en el constructor
     * @return  vidasJugador: devuelve el número de vidas que quedan al jugador
     */

    public int getVidasJugador() {
        return vidasJugador;
    }

    /**
     * Función modificar vidas del jugador que estan guardadas en el constructor
     * @param  vidasJugador: número de vida a modificar
     */
    public void setVidasJugador(int vidasJugador) {
        this.vidasJugador = vidasJugador;
    }

    /**
     * Función disparar, recibe las coordenadas, el tablero y el jugador para dirigir los disparos
     * @param x: coordenada fila
     * @param y: coordenada en columna
     * @param tablero: tablero del jugador
     * @param jugador: objeto jugador que tiene el turno de disparar
     * @return  disparo: devuelve true o false si ha acertado el disparo
     */

    public boolean disparar(int x, int y, Tablero tablero, Jugador jugador){
        boolean disparo=false;
        Estado estadoCasilla= tablero.getTablero()[x][y].getEstadoCasilla();
        if (estadoCasilla.equals(Estado.AGUA)) {
            tablero.cambiarCasilla(tablero, x, y, Estado.FALLASTE);
            disparo = true;
        } else if (estadoCasilla.equals(Estado.OCUPADO)) {
            tablero.cambiarCasilla(tablero, x, y, Estado.TOCADO);
            jugador.setVidasJugador(jugador.getVidasJugador() - 1);
            disparo = true;
        } else if (estadoCasilla.equals(Estado.FALLASTE) || estadoCasilla.equals(Estado.TOCADO)) {
            disparo=false;
        }

        return disparo;
    }

/**
 * Función boolean que devuelve true o false si ha podido pedir correctamente la coordenada
 * @return correcto: devuelve true , o false si ha podido recibir las coordenadas
 * */
    public boolean pedirCoordenada() throws InterruptedException {
        boolean correcto=false;

        System.out.println();
        Thread.sleep(1000);
        System.out.println(VERDE + "(Introduce una letra de A a la J)");
        char letraX = scanner.next().charAt(0);
        letraX=Character.toUpperCase(letraX);
        setX(letraX - 'A');
       // Thread.sleep(1000);
        if(comprobarCoordenada(getX())) {
            System.out.println();
            System.out.println(VERDE + "(Introduce el numero de 1 a 10)");
            int columnaY = scanner.nextInt();
            setY(columnaY-1);
            if(comprobarCoordenada(getY())) {
                correcto = true;
            } else{   System.err.println("Coordenada no valida");}
        }else{
            System.err.println("Coordenada no valida");
        }

        return correcto;
    }
/**Función booleana para verificar que las coordenadas introducidas estén dentro de los limites establecidos
 * @param numero  : coordenada recibida como entero
 * @return boolean: true o false si la coordenada cumple las condiciones*/
    public boolean comprobarCoordenada(int numero){
        if(numero<0 ||numero>9) {
            return false;
        } else {
            return true;
        }
    }
/**
 * Función booleana  para determinar la posición del tetramino
 * @param orientacion: recibe el valor entero que se asocia posteriormente a la posición
 * @return  valido: true o false si la orientación está dentro de los parámetros establecidos*/

    public boolean elegirOrientacion(int orientacion){
        boolean valido =false;
        if(orientacion<1 || orientacion>4){
            valido= false;
        }else {
            valido=true;
        }
        return valido;
    }
/**
 * Función void para ubicar el tetramino en tablero
 * @param x: coordenada de fila
 * @param y: coordenada en columna
 * @param tetramino: número de tetramino a crear
 * @param orientacion: número corespondiente a la posición */
    public void colocarTetramino(int x, int y, int tetramino, int orientacion){
        switch (tetramino){
            case 1:
                construirLinea4(orientacion,x,y);
                break;
            case 2:
                construirCuadrado(orientacion,x,y);
                break;
            case 3:
                construirZeta(orientacion,x,y);
                break;
            case 4:
                construirFormaL(orientacion,x,y);
                break;
            case 5:
                construirPodio(orientacion,x,y);
                break;


        }
    }

/**
 * Función void que nos permite construir el tetramino tipo Linea
 * @param orientacion: corresponde al número de la posición escogida por el jugador
 * @param x : coordenada de fila
 * @param y: coordenada de columna */
    public void construirLinea4(int orientacion, int x, int y){

        switch (orientacion) {
            case 1:
                misTetraminos[0].construirNorte(x,y,tablerosJuego);
                break;
            case 2:
                misTetraminos[0].construirSur(x,y,tablerosJuego);
                break;
            case 3:
                misTetraminos[0].construirEste(x,y,tablerosJuego);
                break;
            case 4:
                misTetraminos[0].construirOeste(x,y,tablerosJuego);
                break;
        }
    }
    /**
     * Función void que nos permite construir el tetramino tipo Cuadrado
     * @param orientacion: corresponde al número de la posición escogida por el jugador
     * @param x : coordenada de fila
     * @param y: coordenada de columna */

    private void construirCuadrado(int orientacion, int x, int y) {


        switch (orientacion) {
            case 1:
                misTetraminos[1].construirNorte(x,y,tablerosJuego);
                break;
            case 2:
                misTetraminos[1].construirSur(x,y,tablerosJuego);
                break;
            case 3:
                misTetraminos[1].construirEste(x,y,tablerosJuego);
                break;
            case 4:
                misTetraminos[1].construirOeste(x,y,tablerosJuego);
                break;
        }
    }
    /**
     * Función void que nos permite construir el tetramino tipo Zeta
     * @param orientacion: corresponde al número de la posición escogida por el jugador
     * @param x : coordenada de fila
     * @param y: coordenada de columna */
    private void construirZeta(int orientacion, int x, int y) {

        switch (orientacion) {
            case 1:
                misTetraminos[2].construirNorte(x,y,tablerosJuego);
                break;
            case 2:
                misTetraminos[2].construirSur(x,y,tablerosJuego);
                break;
            case 3:
                misTetraminos[2].construirEste(x,y,tablerosJuego);
                break;
            case 4:
                misTetraminos[2].construirOeste(x,y,tablerosJuego);
                break;
        }
    }
    /**
     * Función void que nos permite construir el tetramino tipo FormaL
     * @param orientacion: corresponde al número de la posición escogida por el jugador
     * @param x : coordenada de fila
     * @param y: coordenada de columna */
    private void construirFormaL(int orientacion, int x, int y) {

        switch (orientacion) {
            case 1:
                misTetraminos[3].construirNorte(x,y,tablerosJuego);
                break;
            case 2:
                misTetraminos[3].construirSur(x,y,tablerosJuego);
                break;
            case 3:
                misTetraminos[3].construirEste(x,y,tablerosJuego);
                break;
            case 4:
                misTetraminos[3].construirOeste(x,y,tablerosJuego);
                break;
        }
    }
    /**
     * Función void que nos permite construir el tetramino tipo Podio
     * @param orientacion: corresponde al número de la posición escogida por el jugador
     * @param x : coordenada de fila
     * @param y: coordenada de columna */
    private void construirPodio(int orientacion, int x, int y) {

        switch (orientacion) {
            case 1:
                misTetraminos[4].construirNorte(x,y,tablerosJuego);
                break;
            case 2:
                misTetraminos[4].construirSur(x,y,tablerosJuego);
                break;
            case 3:
                misTetraminos[4].construirEste(x,y,tablerosJuego);
                break;
            case 4:
                misTetraminos[4].construirOeste(x,y,tablerosJuego);
                break;
        }
    }

    /**
     * Función void para borrar un tetramino dentro del array tetramino inicializandolo al valor de tetramino Zero
     * @param misTetraminos: array de tetrainos sobre el que se va ha trabajar
     * @param indice: es el indice de posición que se modificará */
    public void borrarTetramino(Tetramino [] misTetraminos, int indice){

        misTetraminos[indice]= new TetraminoZero();

    }

    /**Función que nos permite localizar nuestro tetramino dentro del array
     * @param misTetraminos: array sobre el que se realizará la busqueda
     * @param tetramino: tetraino que buscar dentro del array
     * @return i: indice de la posición del tetramino dentro del array*/
    public int buscarTetramino(Tetramino [] misTetraminos, Tetramino tetramino){
        for (int i = 0; i < misTetraminos.length ; i++) {
            if(misTetraminos[i].getNombreTetramino().equals(tetramino.getNombreTetramino())){
              return i;
            }
        }
        return -1;
    }
    /**
     * Función que devuelve valor booleano si el tetramino se ha ubicado o no en el tablero
     * @param indice: valor entero que corresponde al indice de la posición del tetramino en el array
     * @return boolea: true o false si está colocado  o no.*/
    public boolean tetraminoEnPosicion(int indice){
        return misTetraminos[indice].isColocado();
    }
}
