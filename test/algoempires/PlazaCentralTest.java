package algoempires;

import algoempires.entidad.edificio.PlazaCentral;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlazaCentralTest {

    @Test
    public void test01PlazaCentralCreaAldeanoCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Casillero casilleroACrearAldeano = new Casillero(5, 4);

        PlazaCentral plazaCentral = new PlazaCentral(terreno, casillero);

        plazaCentral.crearAldeano(casilleroACrearAldeano);

        assertTrue(terreno.estaOcupada(casilleroACrearAldeano));
    }
}
