/**
 * @author:Pablo Herrera;
 * @author: Fernando García;
 * @author:Johana Pardo;
 * @version:21.03.2023
 * */
package com.funciones;


public abstract class Tetramino implements FuncionesTetramino {

    static final int PUNTOS_DE_VIDA = 4;
    private String nombreTetramino;
    private int posicionX;
    private int posicionY;
    private int vidas=PUNTOS_DE_VIDA;
    protected int contadorOK=0;
    private boolean colocado;
    public Tetramino(String nombreTetramino, int posicionX, int posicionY) {
        this.nombreTetramino = nombreTetramino;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        colocado=false;
        this.vidas =PUNTOS_DE_VIDA;
    }
/**Funcion tipo getter para devolverel nombre del tetramino
 * @return  nombreTetramino: cadena de texto con nombre */
    public String getNombreTetramino() {
        return nombreTetramino;
    }

    public void setNombreTetramino(String nombreTetramino) {
        this.nombreTetramino = nombreTetramino;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public boolean isColocado() {
        return colocado;
    }

    public void setColocado(boolean colocado) {
        this.colocado = colocado;
    }

    /**Función void para restar las vidas a cada jugador después de un impacto*/
    public void impacto(){
        setVidas(getVidas()-1);
        if(getVidas()==0){
            System.out.println("Tetramino hundido");
        }

    }
    /**Función booleana que comprueba el limite de las coordenada que estén dentro de los establecidos
     * @param x : coordenada en fila
     * @param y : coordenada en columna
     * @return boolean: true si es correcta la coordenada, sino false.*/
    protected boolean comprobarLimite(int x, int y){
        if(x<0 ||x>9 ||y<0 ||y>9) {
            return false;
        } else {
            return true;
        }
    }

}

