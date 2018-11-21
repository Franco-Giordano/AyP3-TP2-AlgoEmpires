package algoempires;

import algoempires.entidad.EntidadFueraDeRangoException;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedioNoPuedeAtacarUnidades;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;


    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
        jugadorDePrueba.sumarOro(10000);
    }

    @Test
    public void jugadorAtacaBienConArqueroAEdificios() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(3, 3), cuartel);

        jugadorDePrueba.atacar(arquero, new Posicion(3, 3));

        assertTrue(cuartel.tieneEstaVida(240));
    }

    @Test
    public void jugadorAtacaBienConArqueroAUnidades() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(arquero, new Posicion(2, 2));

        assertTrue(aldeano.tieneEstaVida(35));
    }

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConArqueroPorDistanciaDeLaUnidadTest() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(9, 9), aldeano);

        jugadorDePrueba.atacar(arquero, new Posicion(9, 9));

    }

    @Test
    public void jugadorAtacaBienConEspadachinAEdificios() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), cuartel);

        jugadorDePrueba.atacar(espadachin, new Posicion(2, 2));

        assertTrue(cuartel.tieneEstaVida(235));
    }

    @Test
    public void jugadorAtacaBienConEspadachinAUnidades() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(espadachin, new Posicion(2, 2));

        assertTrue(aldeano.tieneEstaVida(25));
    }

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConEspadachinPorDistanciaDeLaUnidadTest() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(3, 3), aldeano);

        jugadorDePrueba.atacar(espadachin, new Posicion(3, 3));

    }

    @Test
    public void jugadorAtacaBienConArmaDeAsedioAEdificios() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), cuartel);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(2, 2));

        assertTrue(cuartel.tieneEstaVida(175));
    }

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConArmaDeAsedioPorDistanciaDeLEdificioTest() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(7, 7), cuartel);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(7, 7));

    }

    @Test(expected = ArmaDeAsedioNoPuedeAtacarUnidades.class)
    public void jugadorConArmaDeAsedioNoPuedeAtacarUnidades() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(2, 2));
    }

    @Test
    public void matarAldeanosBajaLaProduccionDeOro() {

        PlazaCentral plazaCentral = new PlazaCentral(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), plazaCentral);

        Posicion posicion = new Posicion(3, 3);

        jugadorDePrueba.crearAldeano(plazaCentral, posicion);

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 9995);

        jugadorDePrueba.informarDestruccion((Unidad) terreno.obtenerEntidadEnPosicion(new Posicion(1, 3)));

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 10015);


    }

}
