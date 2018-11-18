/*package algoempires;

import algoempires.entidad.edificio.PlazaCentral;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlazaCentralTest {

    @Test
    public void testPlazaCentralCreaAldeanoCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(3, 3);

        Posicion posicionACrearAldeano = new Posicion(5, 4);

        PlazaCentral plazaCentral = new PlazaCentral(terreno, posicion);

        plazaCentral.crearAldeano(posicionACrearAldeano);

        assertTrue(terreno.estaOcupada(posicionACrearAldeano));
    }
}*/
