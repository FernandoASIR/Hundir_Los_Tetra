import com.funciones.Casilla;
import com.funciones.Estado;
import com.funciones.Jugador;
import com.funciones.Tablero;

import java.util.Random;
import java.util.Scanner;
/*Debe controlar los turnos de cada jugador,
 el pc disparará al azar (sin repetir)
 y el humano se le pedirá unas coordenadas
 (que deben ser válidas) e imprimirá los
 tableros del jugador humano.
 Cuándo el Pc o el jugador hundan todos los barcos,
 indicará quien ha ganado y terminará el juego.
  */
public class Juego {

    /*CONSTANTES PARA LOS COLORES*/
    public static final String BLANCO = "\u001B[0m";
    public static final String ROJO = "\033[31m";
    public static final String NARANJA = "\033[33m";
    public static final String VERDE = "\u001B[32m";

    public static void main(String[] args) throws InterruptedException {
        
        /**El orden de juego seria el siguiente:
        0-Crear los objetos necesarios
        1-Crear los tableros
        2-Mostrar el tablero del jugador
        3-Pedir al jugador que ponga sus tetraminos en sus coordenadas
        4-Imprimir el tablero jugador actualizado
        5-Mostrar el tablero maquina actualizado
        6-Comenzar por el turno del jugador
        7-Imprimir tablero maquina actualizado (para ver donde ha disparado)
        8-Turno maquina aleatorio
        9-Imprimir el tablero del jugador para que vea donde le han disparado
        10-Volver al paso 5 (un bucle)
        11-Declarar ganador
        12-Meter todoo en un bucle para pedir revancha
        **/


        boolean partida = false; //Para decidir si quiere revancha
        do {
            //Fase 0: Crear los objetos necesarios
            Tablero humanoTab = new Tablero(); //Tablero jugador
            Tablero maquinaTab = new Tablero(); //Tablero maquina
            Jugador humano = new Jugador("Humano", humanoTab); //Jugador jugador
            Jugador maquina = new Jugador("Maquina", maquinaTab); //Jugador Maquina
            Scanner sc = new Scanner(System.in);

            //Fase 1: Crear los tableros

            //Tablero del jugador
            humanoTab.prepararTablero();

            //Creamos el Tablero de la Maquina y establecemos los barcos
            maquinaTab.prepararTablero();

            //Preparacion del tablero maquina
            int tetraminosColocadosMaquina = 1;
            do {
                do{
                    Random rand = new Random();
                    int x, y;
                    x = rand.nextInt(10);
                    y = rand.nextInt(10);

                    int orientacionMaq;
                    orientacionMaq= rand.nextInt(4)+1;

                    maquina.colocarTetramino(x,y, tetraminosColocadosMaquina, orientacionMaq);

                }while(!maquina.tetraminoEnPosicion(tetraminosColocadosMaquina - 1));
                tetraminosColocadosMaquina++;
            } while (tetraminosColocadosMaquina <= Jugador.MAX_TETRAMINOS);


            //Fase 2: Mostrar su tablero al jugador
            textos(1);
            String nombre = sc.nextLine();
            humano.setNombreJugador(nombre);
            System.out.println();
            Thread.sleep(1000);
            System.out.println(BLANCO + "-Conque te llamas " + NARANJA + humano.getNombreJugador() + BLANCO + " eh?. Bueno... hay nombres peores...");
            System.out.println();
            Thread.sleep(1500);
            System.out.println(BLANCO + "-Este de aquí será tu tablero grumete " + NARANJA + humano.getNombreJugador() + BLANCO + ":");
            System.out.println();
            Thread.sleep(2000);
            System.out.println(BLANCO + "-------------------------------------------------------");
            humanoTab.imprimirTableroJugador();
            System.out.println();
            System.out.println(BLANCO + "-------------------------------------------------------");

            //Fase 3: Pedir al jugador que ponga los tetraminos en las coordenadas:
            Thread.sleep(1500);
            mostrarTetraminos();
            int tetraminosColocados = 1;
            do {
                do{
                System.out.println();
                System.out.println(BLANCO + "Introduce tus barcos");
                System.out.println();
                System.out.println(BLANCO+ "Tetramino " +  humano.getMisTetraminos()[tetraminosColocados-1].getNombreTetramino()+" seleccionado.");
                boolean coordenada = humano.pedirCoordenada();
                System.out.println();
                System.out.println(BLANCO + "Elegir orientacion");
                System.out.println();
                System.out.println(VERDE + "(Escribe: 1 para Norte || 2 para Sur || 3 para Este || 4 para Oeste)");
                System.out.println();
                int orientacion = sc.nextInt();
                if (coordenada && humano.elegirOrientacion(orientacion)) {
                    humano.colocarTetramino(humano.getX(), humano.getY(), tetraminosColocados, orientacion);


                    humanoTab.imprimirTableroJugador();
                } else {
                    if (!coordenada) {
                        System.err.println("Coordenada no valida");
                    } else {
                        System.err.println("Orientacion no valida");
                    }
                }
                    if(!humano.tetraminoEnPosicion(tetraminosColocados-1)){
                        System.err.println("Posicion no valida");
                    }
                }while(!humano.tetraminoEnPosicion(tetraminosColocados - 1));
                System.out.println();
                System.out.println(BLANCO+"Barco " + BLANCO+ humano.getMisTetraminos()[tetraminosColocados-1].getNombreTetramino()+" colocado");
                tetraminosColocados++;

            } while (tetraminosColocados<= Jugador.MAX_TETRAMINOS);

            //Fase 5: Mostrar el tablero maquina actualizado
            Thread.sleep(1500);
            System.out.println();
            System.out.println(BLANCO + "-Y aquí se esconde tu enemigo: ");
            Thread.sleep(1500);
            maquinaTab.imprimirTableroMaquina();

            //Fase 6 y 7: Comenzar por el turno del jugador y mostrar el disparo en tablero maquina
            do{
                textos(4);
                boolean turnoJugador = false;
                    do {
                        System.out.println("");
                        boolean coordenada = humano.pedirCoordenada();
                        if (coordenada && (maquinaTab.comprobarCasilla(humano.getX(), humano.getY(), Estado.AGUA) || maquinaTab.comprobarCasilla(humano.getX(), humano.getY(), Estado.OCUPADO))) {
                            humano.disparar(humano.getX(), humano.getY(), maquinaTab, maquina);
                            maquinaTab.imprimirTableroMaquina();
                            turnoJugador = true;
                        }
                    } while (!turnoJugador);
                    System.out.println();

                //Fase 8: Turno maquina

                if(maquina.getVidasJugador()>0) {
                    textos(5);
                    boolean turnoMaquina = false;
                    do {
                        Random rand = new Random();
                        int x, y;
                        x = rand.nextInt(10);
                        y = rand.nextInt(10);
                        if (humanoTab.comprobarCasilla(x, y, Estado.AGUA) || humanoTab.comprobarCasilla(x, y, Estado.OCUPADO)) {
                            maquina.disparar(x, y, humanoTab, humano);
                            Thread.sleep(1500);
                            System.out.println();
                            char letraX = (char) (x + 'A');
                            System.out.println("-Tu enemigo te ha disparado en " + ROJO + letraX + BLANCO + "-" + ROJO + (y+1));
                            Thread.sleep(1500);
                            System.out.println();
                            System.out.println(BLANCO + "-Asi quedan las cosas:");
                            Thread.sleep(1500);
                            humanoTab.imprimirTableroJugador();
                            turnoMaquina = true;
                        }
                    } while (!turnoMaquina);
                }
            } while (humano.getVidasJugador()>0 && maquina.getVidasJugador()>0);

            //Fase 9: Desenlace de la partida
            if (humano.getVidasJugador() == 0) {
                textos(2);
                int revancha = sc.nextInt();
                if (revancha == 1) {
                    partida = false;
                } else if (revancha == 2) {
                    partida = true;
                }
            } else if (maquina.getVidasJugador() == 0) {
                textos(3);
                int revancha = sc.nextInt();
                if (revancha == 1) {
                    partida = false;
                } else if (revancha == 2) {
                    partida = true;
                }
            }
        } while (partida == false);
    }



    /*FUNCIONES*/
    /**Función void que muestra los tetraminos a elegir*/
    public static void mostrarTetraminos () throws InterruptedException {
        Thread.sleep(1000);
        System.out.println();
        System.out.println(BLANCO + "-Está un poco soso ¿no? ¿Y si establecemos tu flota?");
        Thread.sleep(2000);
        System.out.println();
        System.out.println(NARANJA + "-Estos son tus barcos: ");
        System.out.println(VERDE + "1." + BLANCO + "[][][][]  " + VERDE + "2." + BLANCO + "[][] " + VERDE + " 3." + BLANCO + "[][]   " + VERDE + "4." + BLANCO + "[]     " + VERDE + "5." + BLANCO + "  []    ");
        System.out.println("              [][]      [][]   [][][]   [][][]  ");
        System.out.println();

    }
/**Función void que guarda los textos a mostrar en cada ocasión del programa*/
    public static void textos ( int caso) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        switch (caso) {
            case 1: //Introducción del juego
                System.out.println(NARANJA + "¡La batalla naval está apunto de empezar!");
                System.out.println();
                Thread.sleep(2000);
                System.out.println(BLANCO + "-¿Estás preparado " + ROJO + "GRUMETE DE POCA MONTA" + BLANCO + "?");
                System.out.println();
                Thread.sleep(1500);
                System.out.println("-Pero lo primero es lo primero, dime tu nombre " + ROJO + "ALIMAÑA DE AGUA DULCE");
                System.out.println();
                Thread.sleep(2000);
                System.out.println(VERDE + "(Escribe aquí debajo tu nombre)");
                System.out.println();
                break;
            case 2: //Frases al perder
                System.out.println();
                System.out.println(BLANCO + "-Una pena grumete, has perdido");
                System.out.println();
                System.out.println("-¿Quieres la revancha?");
                System.out.println(VERDE + "(Responde 1 para revancha o 2 para cerrar el programa");
                break;
            case 3: //Frases al ganar
                System.out.println();
                System.out.println(BLANCO + "-¡Felicidades marinero!" + NARANJA + "¡Eres el vencedor!");
                System.out.println();
                System.out.println(BLANCO + "-¿Quieres volver a jugar grumete?");
                System.out.println(VERDE + "(Responde 1 para revancha o 2 para cerrar el programa");
                break;
            case 4: //Frases de inicio de turno
                Thread.sleep(2000);
                System.out.println();
                System.out.println(NARANJA + "------------Nuevo-Turno------------");
                System.out.println();
                System.out.println(BLANCO + "¡Hora de bombardear marinero!");
                break;
            case 5:
                Thread.sleep(2000);
                System.out.println();
                System.out.println(ROJO + "------------Nuevo-Turno------------");
                System.out.println();
                System.out.println(BLANCO + "-Es el turno de tu enemigo. ¡A cubierto!");
        }
    }

}