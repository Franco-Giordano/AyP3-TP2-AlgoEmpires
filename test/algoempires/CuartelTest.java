package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.excepciones.EdificioNoFuncionalException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CuartelTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
    }

    @Test
    public void testcreaEspadachinCorrectamente() throws DimensionesInvalidasException, PosicionInvalidaException {

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        cuartel.continuarConstruccion();
        cuartel.continuarConstruccion();
        cuartel.continuarConstruccion();

        terreno.ocupar(new Posicion(1, 1), cuartel.crearEspadachin());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));

    }

    @Test
    public void testcreaArqueroCorrectamente() throws DimensionesInvalidasException, PosicionInvalidaException {

        jugadorDePrueba.sumarOro(1000);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        cuartel.continuarConstruccion();
        cuartel.continuarConstruccion();
        cuartel.continuarConstruccion();

        terreno.ocupar(new Posicion(1, 1), cuartel.crearArquero());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));

    }


    @Test (expected = EdificioNoFuncionalException.class)
    public void testNoSePuedeCrearEspadachinSiElEdificioNoEsFuncional() throws DimensionesInvalidasException,
            PosicionInvalidaException, EdificioNoFuncionalException {

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), cuartel.crearEspadachin());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }

    @Test (expected = EdificioNoFuncionalException.class)
    public void testNoSePuedeCrearArqueroSiElEdificioNoEsFuncional() throws DimensionesInvalidasException,
            PosicionInvalidaException, EdificioNoFuncionalException {

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), cuartel.crearArquero());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }


}
