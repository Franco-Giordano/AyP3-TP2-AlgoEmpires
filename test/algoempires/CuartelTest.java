/*package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CuartelTest {

    @Test
    public void testcreaEspadachinCorrectamente() throws DimensionesInvalidasError, PosicionInvalidaException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(3, 3);

        Posicion posicionACrearEspadachin = new Posicion(5, 4);

        Cuartel cuartel = new Cuartel(terreno, posicion);

        cuartel.crearEspadachin(posicionACrearEspadachin);

        assertTrue(terreno.estaOcupada(posicionACrearEspadachin));

    }

    @Test
    public void testcreaArqueroCorrectamente() throws DimensionesInvalidasError, PosicionInvalidaException{

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(3, 3);

        Posicion posicionACrearArquero = new Posicion(5, 4);

        Cuartel cuartel = new Cuartel(terreno, posicion);

        cuartel.crearArquero(posicionACrearArquero);

        assertTrue(terreno.estaOcupada(posicionACrearArquero));

    }
}*/
