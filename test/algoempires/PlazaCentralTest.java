package algoempires;

import algoempires.entidad.edificio.PlazaCentral;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralCreaAldeanoCorrectamente() {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        jugador.sumarOro(1000);

        PlazaCentral plazaCentral = new PlazaCentral(jugador);

        terreno.ocupar(new Posicion(1, 1), plazaCentral.crearAldeano());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }
}
