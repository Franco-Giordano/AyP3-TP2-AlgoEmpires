package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.utilero.Aldeano;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerrenoTest {

    @Test
    public void test01TerrenoAsignaBienElTamanio() throws DimensionesInvalidasError {

        Terreno terreno = new Terreno(5, 4);

        assertEquals(terreno.getTamHorizontal(), 5);
        assertEquals(terreno.getTamVertical(), 4);
    }

/*
    @Test(expected = DimensionesInvalidasError.class)
    public void test02TerrenoNoAceptaDimensionesNegativas() throws DimensionesInvalidasError {

        Terreno terreno = new Terreno(-1,4);

    }*/

    @Test
    public void test03ColocarUnidadOcupaSoloUnCasillero() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(2, 2);

        Aldeano aldeano = new Aldeano(terreno, new Casillero(2, 2));

        assertTrue(terreno.estaOcupada(new Casillero(2, 2)));

        assertFalse(terreno.estaOcupada(new Casillero(1, 1)));
        assertFalse(terreno.estaOcupada(new Casillero(2, 1)));
        assertFalse(terreno.estaOcupada(new Casillero(1, 2)));

    }

    @Test
    public void test04ColocarEdificioOcupaLoQueCorresponde() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(3, 3);

        Cuartel cuartel = new Cuartel(terreno, new Casillero(2, 2));

        assertTrue(terreno.estaOcupada(new Casillero(2, 2)));
        assertTrue(terreno.estaOcupada(new Casillero(3, 2)));
        assertTrue(terreno.estaOcupada(new Casillero(2, 3)));
        assertTrue(terreno.estaOcupada(new Casillero(3, 3)));

        assertFalse(terreno.estaOcupada(new Casillero(1, 1)));
        assertFalse(terreno.estaOcupada(new Casillero(2, 1)));
        assertFalse(terreno.estaOcupada(new Casillero(1, 2)));
        assertFalse(terreno.estaOcupada(new Casillero(1, 3)));
        assertFalse(terreno.estaOcupada(new Casillero(3, 1)));

    }

}
