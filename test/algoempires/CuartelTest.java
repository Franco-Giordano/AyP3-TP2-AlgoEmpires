package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CuartelTest {

    @Test
    public void testcreaEspadachinCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Casillero casilleroACrearEspadachin = new Casillero(5, 4);

        Cuartel cuartel = new Cuartel(terreno, casillero);

        cuartel.crearEspadachin(casilleroACrearEspadachin);

        assertTrue(terreno.estaOcupada(casilleroACrearEspadachin));

    }

    @Test
    public void testcreaArqueroCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException{

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Casillero casilleroACrearArquero = new Casillero(5, 4);

        Cuartel cuartel = new Cuartel(terreno, casillero);

        cuartel.crearArquero(casilleroACrearArquero);

        assertTrue(terreno.estaOcupada(casilleroACrearArquero));

    }
}
