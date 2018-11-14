package algoempires;

import algoempires.entidad.edificio.Cuartel;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CuartelTest {

    @Test
    public void test01creaEspadachinCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Casillero casilleroACrearEspadachin = new Casillero(5, 4);

        Cuartel cuartel = new Cuartel(terreno, casillero);

        cuartel.crearEspadachin(casilleroACrearEspadachin);

        assertTrue(terreno.estaOcupada(casilleroACrearEspadachin));

    }
}
