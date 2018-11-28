package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

import java.util.Random;

public class AlgoEmpires {

    private Jugador[] jugadores;
    private Terreno terrenoDeJuego;

    public AlgoEmpires(int tamHorizontal, int tamVertical, String nombre1, String nombre2) throws DimensionesInvalidasException {

        if (tamHorizontal < 20 || tamVertical < 20) {
            throw new DimensionesInvalidasException("Para ubicar los bienes iniciales, el terreno debe ser de al menos 20x20 casilleros");
        }

        this.terrenoDeJuego = new Terreno(tamHorizontal, tamVertical);

        Jugador jugador1 = new Jugador(nombre1, terrenoDeJuego);
        Jugador jugador2 = new Jugador(nombre2, terrenoDeJuego);

        jugadores = new Jugador[]{jugador1, jugador2};

        this.prepararJugadoresParaBatalla(tamHorizontal, tamVertical);
    }

    private void prepararJugadoresParaBatalla(int tamHoriz, int tamVert) {

        asignarBienesJugadorCentradoEn(jugadores[0], new Posicion(1, 1));

        Posicion maximo = new Posicion(tamHoriz, tamVert);
        asignarBienesJugadorCentradoEn(jugadores[1], new Posicion(-8, -8, maximo));
    }

    private void asignarBienesJugadorCentradoEn(Jugador jugador, Posicion desplazamiento) {

        jugador.sumarOro(100 + 25 + 25 + 25); //cubrir los gastos de creacion

        Posicion posCastillo = new Posicion(4, 1, desplazamiento);
        Castillo castillo = new Castillo(jugador);

        Posicion posPlaza = new Posicion(1, 6, desplazamiento);
        PlazaCentral plaza = new PlazaCentral(jugador);
        plaza.sumarVida(300);


        Posicion posAld1 = new Posicion(2, 4, desplazamiento);
        Aldeano ald1 = new Aldeano(jugador);

        Posicion posAld2 = new Posicion(3, 5, desplazamiento);
        Aldeano ald2 = new Aldeano(jugador);

        Posicion posAld3 = new Posicion(4, 6, desplazamiento);
        Aldeano ald3 = new Aldeano(jugador);

        jugador.posicionarLaEntidad(posCastillo, castillo);
        jugador.posicionarLaEntidad(posPlaza, plaza);
        jugador.posicionarLaEntidad(posAld1, ald1);
        jugador.posicionarLaEntidad(posAld2, ald2);
        jugador.posicionarLaEntidad(posAld3, ald3);
    }

    private void jugarPartida() {

        int i = escogerJugadorAlAzar();

        //TODO Luego chequear condicion de perdida/victoria
        while (true) {

            jugadores[i].jugarTurno();

            i++;
            i = i % 2;
        }

    }

    private int escogerJugadorAlAzar() {

        Random random = new Random();

        return random.nextInt(2);
    }


    //METODO DE TESTEO
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Terreno getTerreno() {
        return terrenoDeJuego;
    }
}
