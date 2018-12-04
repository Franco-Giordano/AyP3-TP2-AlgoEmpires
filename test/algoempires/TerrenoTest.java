package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
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
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
    }

    @Test
    public void testTerrenoAsignaBienElTamanio() throws DimensionesInvalidasException {

        Terreno terreno = new Terreno(5, 4);

        assertEquals(terreno.getTamHorizontal(), 5);
        assertEquals(terreno.getTamVertical(), 4);
    }

    @Test(expected = DimensionesInvalidasException.class)
    public void testTerrenoNoAceptaDimensionesNegativas() throws DimensionesInvalidasException {

        new Terreno(-1, 4);

    }

    @Test
    public void testColocarUnidadOcupaSoloUnCasillero() throws DimensionesInvalidasException, PosicionInvalidaException {

        terreno.ocupar(new Posicion(2, 2), new Aldeano(jugadorDePrueba));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));

        assertFalse(terreno.estaOcupada(new Posicion(1, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 2)));

    }

    @Test
    public void testColocarEdificioOcupaLoQueCorresponde() throws DimensionesInvalidasException, PosicionInvalidaException {
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

        terreno.ocupar(new Posicion(15, 2), new Aldeano(jugadorDePrueba));
    }

    @Test(expected = PosicionInvalidaException.class)
    public void testNoSePuedeUbicarEdificioFueraDeTerreno() {

        terreno.ocupar(new Posicion(15, 2), new Castillo(jugadorDePrueba));

    }

    @Test(expected = PosicionInvalidaException.class)
    public void testUnidadNoSePuedeMoverFueraDeTerreno() {

        Posicion posicion = new Posicion(10, 10);

        Arquero unidad = new Arquero(jugadorDePrueba);

        terreno.ocupar(posicion, unidad);

        Direccion direccion = new DireccionArriba();

        terreno.moverUnidad(posicion, direccion);
    }

    @Test
    public void removerUnaEntidadDelTerreno() {
        Aldeano aldeano = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(5, 5), aldeano);

        assertTrue(terreno.estaOcupada(new Posicion(5, 5)));
        terreno.remover(aldeano);

        assertFalse(terreno.estaOcupada(new Posicion(5, 5)));
    }
}

