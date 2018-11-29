package algoempires;

import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlgoEmpiresTest {

    @Test
    public void testJuegoAsignaBienesIniciales() {
        AlgoEmpires juego = new AlgoEmpires(30, 30, "Carlos", "Juan");

        Jugador[] jugadores = juego.getJugadores();

        assertTrue(jugadores[0].tieneCastilloEn(new Posicion(5, 2)));
        assertTrue(jugadores[0].tienePlazaCentralEn(new Posicion(2, 7)));
        assertTrue(jugadores[0].tieneAldeanoEn(new Posicion(3, 5)));
        assertTrue(jugadores[0].tieneAldeanoEn(new Posicion(4, 6)));
        assertTrue(jugadores[0].tieneAldeanoEn(new Posicion(5, 7)));
        assertTrue(jugadores[0].tieneEstaCantidadDePropiedades(3, 2));
        assertEquals(jugadores[0].getOro(), 100);


        assertTrue(jugadores[1].tieneCastilloEn(new Posicion(27, 24)));
        assertTrue(jugadores[1].tienePlazaCentralEn(new Posicion(24, 29)));
        assertTrue(jugadores[1].tieneAldeanoEn(new Posicion(25, 27)));
        assertTrue(jugadores[1].tieneAldeanoEn(new Posicion(26, 28)));
        assertTrue(jugadores[1].tieneAldeanoEn(new Posicion(24, 26)));
        assertTrue(jugadores[1].tieneEstaCantidadDePropiedades(3, 2));
        assertEquals(jugadores[1].getOro(), 100);

    }

    @Test(expected = DimensionesInvalidasException.class)
    public void testNosePermitenDimensionesChicas() {
        AlgoEmpires juego = new AlgoEmpires(13, 5,"Carlos", "Juan");
    }
}
