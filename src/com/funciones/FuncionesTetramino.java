/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @authot:Johana Pardo;
 * @version:21-03-2023
 * */
package com.funciones;
/**

 Interfaz que define las funciones para construir un tetramino en un tablero dado una posición inicial
 y una orientación cardinal.
 */
public interface FuncionesTetramino{

    /**

     Función para construir el tetramino desde el punto inicial entregado por el usuario orientado hacia
     el norte.
     @param posicionX La posición en el eje X donde se empezará a construir el tetramino.
     @param posicionY La posición en el eje Y donde se empezará a construir el tetramino.
     @param tablero El tablero en el cual se construirá el tetramino.
     */
    public void construirNorte(int posicionX,int posicionY, Tablero tablero);
    /**

     Función para construir el tetramino desde el punto inicial entregado por el usuario orientado hacia
     el sur.
     @param posicionX La posición en el eje X donde se empezará a construir el tetramino.
     @param posicionY La posición en el eje Y donde se empezará a construir el tetramino.
     @param tablero El tablero en el cual se construirá el tetramino.
     */
    public void construirSur(int posicionX,int posicionY, Tablero tablero);
    /**

     Función para construir el tetramino desde el punto inicial entregado por el usuario orientado hacia
     el este.
     @param posicionX La posición en el eje X donde se empezará a construir el tetramino.
     @param posicionY La posición en el eje Y donde se empezará a construir el tetramino.
     @param tablero El tablero en el cual se construirá el tetramino.
     */
    public void construirEste(int posicionX,int posicionY, Tablero tablero);
    /**

     Función para construir el tetramino desde el punto inicial entregado por el usuario orientado hacia
     el oeste.
     @param posicionX La posición en el eje X donde se empezará a construir el tetramino.
     @param posicionY La posición en el eje Y donde se empezará a construir el tetramino.
     @param tablero El tablero en el cual se construirá el tetramino.
     */
    public void construirOeste(int posicionX,int posicionY, Tablero tablero);
}