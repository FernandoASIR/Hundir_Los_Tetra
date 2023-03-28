# HUNDIR LOS TETRAMINOS

Este es un juego de Hundir la Flota, sustituyendo los clasicos
barcos por los tetraminos del tetris, se haimplementado en Java. 
El objetivo del juego es hundir todos los tetraminos del oponente antes de que hunda los tuyos.

## Versión de java utilizada
JAVA 11 Temurin

## IDE
IntelliJ IDEA Community Edition 2022.2.2

## Componentes del grupo.
- Johana Pardo
- Pablo Herrera
- Fernando García

## Instrucciones de juego

1. El programa controla los turnos de cada jugador y el PC dispara al azar sin repetir.

2. El juego comienza por la creación de los objetos necesarios, seguido por la creación de los tableros del jugador humano y del PC. En el tablero PC se colocaran automaticamente de forma aleatoria sus tetraminos. Luego se le pide al jugador que coloque sus tetraminos en su tablero.

3. Después de esto, el programa entra en un ciclo de turnos donde el jugador humano dispara y luego el PC dispara al azar.

4. El programa imprime los tableros del jugador después de cada turno para que el jugador pueda ver donde ha disparado el oponente.

5. El ciclo de turnos continúa hasta que uno de los jugadores hunde todos los tetraminos del oponente, momento en el cual se declara un ganador y se termina el juego.

6. Después de esto, el programa permite al usuario elegir si desea jugar una revancha.
## Características de la rúbrica que no se han podido implementar

1. Que 'imprimirTableroJugador' e'imprimirTableroMaquina' fueran un solo metodo imprimir.
2. Optimizar el metodo para recibir coordenadas por parte del jugador, para evitar fallos.
3. Implementar metodos para que indique cuando se hunde un tetramino y mostrar ese estado en el tablero.