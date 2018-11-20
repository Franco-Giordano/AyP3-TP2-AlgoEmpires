package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;
import algoempires.tablero.direccion.DireccionArriba;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TerrenoTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
    }

    @Test
    public void testTerrenoAsignaBienElTamanio() throws DimensionesInvalidasError {

        Terreno terreno = new Terreno(5, 4);

        assertEquals(terreno.getTamHorizontal(), 5);
        assertEquals(terreno.getTamVertical(), 4);
    }

    @Test(expected = DimensionesInvalidasError.class)
    public void testTerrenoNoAceptaDimensionesNegativas() throws DimensionesInvalidasError {

        new Terreno(-1, 4);

    }

    @Test
    public void testColocarUnidadOcupaSoloUnCasillero() throws DimensionesInvalidasError, PosicionInvalidaException {
        Terreno terreno = new Terreno(2, 2);

        terreno.ocupar(new Posicion(2, 2), new Aldeano(jugadorDePrueba));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));

        assertFalse(terreno.estaOcupada(new Posicion(1, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 2)));

    }

    @Test
    public void testColocarEdificioOcupaLoQueCorresponde() throws DimensionesInvalidasError, PosicionInvalidaException {

        Terreno terreno = new Terreno(3, 3);

        terreno.ocupar(new Posicion(2, 2), new Cuartel(jugadorDePrueba));

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

    @Test(expected = PosicionInvalidaException.class)
    public void testNoSePuedeUbicarUnidadFueraDelTerreno() throws PosicionInvalidaException {
        Terreno terreno = new Terreno(5, 2);

        terreno.ocupar(new Posicion(6, 2), new Aldeano(jugadorDePrueba));

    }

    @Test(expected = PosicionInvalidaException.class)
    public void testNoSePuedeUbicarEdificioFueraDeTerreno() throws PosicionInvalidaException, DimensionesInvalidasError {
        Terreno terreno = new Terreno(3, 20);

        terreno.ocupar(new Posicion(1, 5), new Castillo(jugadorDePrueba));

    }

    @Test(expected = PosicionInvalidaException.class)
    public void testUnidadNoSePuedeMoverFueraDeTerreno() {

        Posicion posicion = new Posicion(10, 10);

        Terreno terreno = new Terreno(10, 10);

        Arquero unidad = new Arquero(jugadorDePrueba);

        terreno.ocupar(posicion, unidad);

        Direccion direccion = new DireccionArriba();

        terreno.moverUnidad(posicion, direccion);

    }


}

