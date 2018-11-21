package algoempires;

import algoempires.jugador.Jugador;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;

import java.util.Random;

public class AlgoEmpires {

    private Jugador jugadorActual;

    public AlgoEmpires(int tamHorizontal, int tamVertical) throws DimensionesInvalidasError {

        Terreno terrenoDeJuego = new Terreno(30, 30);

        Jugador jugador1 = new Jugador(terrenoDeJuego);
        Jugador jugador2 = new Jugador(terrenoDeJuego);

        jugador1.setContrincante(jugador2);
        jugador2.setContrincante(jugador1);

        this.prepararJugadoresParaBatalla(jugador1, jugador2);

        Jugador[] opciones = {jugador1, jugador2};

        jugadorActual = this.escogerJugadorAlAzar(opciones);

        this.jugarPartida();

    }

    private void prepararJugadoresParaBatalla(Jugador jugador1, Jugador jugador2) {

        //TODO distribuir bienes iniciales
    }

    public static void main(String[] args) {
        //AlgoEmpires juego = new AlgoEmpires(10,10);
    }

    private void jugarPartida() {

        //TODO Luego chequear condicion de perdida/victoria
        while (true) {
            jugadorActual = jugadorActual.jugarTurnoYDevolverSiguienteJugador();
        }

    }

    private Jugador escogerJugadorAlAzar(Jugador[] opciones) {

        Random random = new Random();
        int randomInt = random.nextInt(2);

        return opciones[randomInt];
    }
}
