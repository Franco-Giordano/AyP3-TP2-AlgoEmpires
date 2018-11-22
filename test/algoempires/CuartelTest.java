package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CuartelTest {

    @Test
    public void testcreaEspadachinCorrectamente() throws DimensionesInvalidasException, PosicionInvalidaException {

        Terreno terreno = new Terreno(10, 10);

        Cuartel cuartel = new Cuartel(new Jugador(terreno));

        terreno.ocupar(new Posicion(1, 1), cuartel.crearEspadachin());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));

    }

    @Test
    public void testcreaArqueroCorrectamente() throws DimensionesInvalidasException, PosicionInvalidaException {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        jugador.sumarOro(1000);

        Cuartel cuartel = new Cuartel(jugador);

        terreno.ocupar(new Posicion(1, 1), cuartel.crearArquero());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));

    }
}
