package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerrenoTest {

    @Test
    public void testTerrenoAsignaBienElTamanio() throws DimensionesInvalidasError {

        Terreno terreno = new Terreno(5, 4);

        assertEquals(terreno.getTamHorizontal(), 5);
        assertEquals(terreno.getTamVertical(), 4);
    }

    @Test(expected = DimensionesInvalidasError.class)
    public void testTerrenoNoAceptaDimensionesNegativas() throws DimensionesInvalidasError {

        new Terreno(-1,4);

    }

    @Test
    public void testColocarUnidadOcupaSoloUnCasillero() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(2, 2);

        new Aldeano(terreno, new Posicion(2, 2));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));

        assertFalse(terreno.estaOcupada(new Posicion(1, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 2)));

    }

    @Test
    public void testColocarEdificioOcupaLoQueCorresponde() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(3, 3);

        new Cuartel(terreno, new Posicion(2, 2));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(2, 3)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 3)));

        assertFalse(terreno.estaOcupada(new Posicion(1, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 2)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 3)));
        assertFalse(terreno.estaOcupada(new Posicion(3, 1)));

    }

    @Test(expected = CasilleroInvalidoException.class)
    public void testNoSePuedeUbicarUnidadFueraDelTerreno() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(5, 2);

        new Aldeano(terreno, new Posicion(3, 3));

    }

    @Test(expected = CasilleroInvalidoException.class)
    public void testNoSePuedeUbicarEdificioFueraDeTerreno() throws CasilleroInvalidoException, DimensionesInvalidasError {
        Terreno terreno = new Terreno(3, 20);

        new Castillo(terreno, new Posicion(1, 5));

    }

}
