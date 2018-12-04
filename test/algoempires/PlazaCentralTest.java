package algoempires;

import algoempires.entidad.edificio.PlazaCentral;
import algoempires.excepciones.EdificioNoFuncionalException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PlazaCentralTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
        jugadorDePrueba.sumarOro(1000);
    }


    @Test
    public void testPlazaCentralCreaAldeanoCorrectamente() {

        jugadorDePrueba = new Jugador("Carlos", terreno);

        jugadorDePrueba.sumarOro(1000);

        PlazaCentral plazaCentral = new PlazaCentral(jugadorDePrueba);

        plazaCentral.continuarConstruccion();
        plazaCentral.continuarConstruccion();
        plazaCentral.continuarConstruccion();

        terreno.ocupar(new Posicion(1, 1), plazaCentral.crearAldeano());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }

    @Test(expected = EdificioNoFuncionalException.class)
    public void testNoSePuedeCrearAldeanoEnUnaPlazaNoFuncional() {
        jugadorDePrueba = new Jugador("Carlos", terreno);

        jugadorDePrueba.sumarOro(1000);

        PlazaCentral plazaCentral = new PlazaCentral(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), plazaCentral.crearAldeano());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }
}
