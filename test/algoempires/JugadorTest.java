package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.excepciones.ArmaDeAsedioNoPuedeAtacarUnidadesException;
import algoempires.excepciones.EntidadFueraDeRangoException;
import algoempires.excepciones.NoSeToleraFuegoAmigoException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Jugador jugadorEnemigo;


    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
        this.jugadorEnemigo = new Jugador("Juan", terreno);
        jugadorDePrueba.sumarOro(10000);
        jugadorEnemigo.sumarOro(10000);
    }

    @Test
    public void jugadorAtacaBienConArqueroAEdificios() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);

        terreno.ocupar(new Posicion(3, 3), cuartel);

        jugadorDePrueba.atacar(arquero, new Posicion(3, 3));

        assertTrue(cuartel.tieneEstaVida((250 / 3) - 10));
    }

    @Test
    public void jugadorAtacaBienConArqueroAUnidades() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(arquero, new Posicion(2, 2));

        assertTrue(aldeano.tieneEstaVida(35));
    }

    @Test
    public void jugadorNoPuedeAtacarConArqueroPorDistanciaDeLaUnidadTest() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(9, 9), aldeano);

        assertTrue(aldeano.tieneEstaVida(50));

        jugadorDePrueba.atacar(arquero, new Posicion(9, 9));

        assertTrue(aldeano.tieneEstaVida(50));

    }

    @Test
    public void jugadorAtacaBienConEspadachinAEdificios() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);

        terreno.ocupar(new Posicion(2, 2), cuartel);

        jugadorDePrueba.atacar(espadachin, new Posicion(2, 2));

        assertTrue(cuartel.tieneEstaVida(68));
    }

    @Test
    public void jugadorAtacaBienConEspadachinAUnidades() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(espadachin, new Posicion(2, 2));

        assertTrue(aldeano.tieneEstaVida(25));
    }

    @Test
    public void jugadorNoPuedeAtacarConEspadachinPorDistanciaDeLaUnidadTest() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(3, 3), aldeano);

        assertTrue(aldeano.tieneEstaVida(50));

        jugadorDePrueba.atacar(espadachin, new Posicion(3, 3));

        assertTrue(aldeano.tieneEstaVida(50));

    }

    @Test
    public void jugadorAtacaBienConArmaDeAsedioAEdificios() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);

        terreno.ocupar(new Posicion(2, 2), cuartel);

        armaDeAsedio.montar();

        armaDeAsedio.actualizarEntreTurnos();

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(2, 2));

        assertTrue(cuartel.tieneEstaVida(8));
    }

    @Test
    public void jugadorNoPuedeAtacarConArmaDeAsedioPorDistanciaDeLEdificioTest() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);

        cuartel.terminarConstruccion();

        terreno.ocupar(new Posicion(7, 7), cuartel);

        assertTrue(cuartel.tieneVidaLlena());

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(7, 7));

        assertTrue(cuartel.tieneVidaLlena());
    }

    @Test(expected = ArmaDeAsedioNoPuedeAtacarUnidadesException.class)
    public void jugadorConArmaDeAsedioNoPuedeAtacarUnidades() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(2, 2));
    }

    @Test
    public void matarAldeanosBajaLaProduccionDeOro() {

        PlazaCentral plazaCentral = new PlazaCentral(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), plazaCentral);

        Posicion posicion = new Posicion(3, 3);

        plazaCentral.continuarConstruccion();
        plazaCentral.continuarConstruccion();
        plazaCentral.continuarConstruccion();

        jugadorDePrueba.crearAldeano(plazaCentral, posicion);

        assertEquals(jugadorDePrueba.getCantidadDeHabitantes(), 1);

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 9995);

        Aldeano aldeano = (Aldeano) terreno.obtenerEntidadEnPosicion(new Posicion(3, 3));
        aldeano.restarVida(500);

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getCantidadDeHabitantes(), 0);

        assertEquals(jugadorDePrueba.getOro(), 9995);

    }

    @Test(expected = NoSeToleraFuegoAmigoException.class)
    public void testNoSePuedenAtacarEdificiosAliados() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), cuartel);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(2, 2));

    }


    @Test(expected = NoSeToleraFuegoAmigoException.class)
    public void testNoSePuedenAtacarUnidadesAliadas() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2, 2), aldeano);

        jugadorDePrueba.atacar(espadachin, new Posicion(2, 2));
    }

    @Test
    public void testJugadorCreaPlazaCentralCorrectamente() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4, 4), aldeano);
        Posicion posicionDeLaPlaza = new Posicion(5, 5);

        assertFalse(terreno.estaOcupada(posicionDeLaPlaza));
        assertFalse(terreno.estaOcupada(new Posicion(6, 6)));
        assertFalse(terreno.estaOcupada(new Posicion(5, 6)));

        jugadorDePrueba.crearPlazaCentral(aldeano, posicionDeLaPlaza);

        assertTrue(terreno.estaOcupada(posicionDeLaPlaza));
        assertTrue(terreno.estaOcupada(new Posicion(6, 6)));
        assertTrue(terreno.estaOcupada(new Posicion(5, 6)));
    }

    @Test
    public void testJugadorCreaCuartelCorrectamente() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4, 4), aldeano);


        assertFalse(terreno.estaOcupada(new Posicion(5, 5)));
        assertFalse(terreno.estaOcupada(new Posicion(6, 6)));
        assertFalse(terreno.estaOcupada(new Posicion(5, 6)));

        jugadorDePrueba.crearCuartel(aldeano, new Posicion(5, 5));

        assertTrue(terreno.estaOcupada(new Posicion(5, 5)));
        assertTrue(terreno.estaOcupada(new Posicion(6, 6)));
        assertTrue(terreno.estaOcupada(new Posicion(5, 6)));
    }

    @Test
    public void testEdificioSeReparaCorrectamente() {

        Aldeano aldeanoAliado = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4, 4), aldeanoAliado);

        Cuartel cuartel = aldeanoAliado.construirCuartel();

        terreno.ocupar(new Posicion(5, 5), cuartel);

        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(cuartel.getVida(), 250);

        cuartel.restarVida(50);

        assertTrue(cuartel.tieneEstaVida(200));

        jugadorDePrueba.reparar(aldeanoAliado, new Posicion(5, 5));

        aldeanoAliado.actualizarEntreTurnos();

        assertTrue(cuartel.tieneEstaVida(250));
    }

    @Test
    public void testPlazaSeReparaCorrectamente() {

        Aldeano aldeanoAliado = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4, 4), aldeanoAliado);

        PlazaCentral plazaCentral = aldeanoAliado.construirPlazaCentral();

        terreno.ocupar(new Posicion(5, 5), plazaCentral);

        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(plazaCentral.getVida(), 450);

        plazaCentral.restarVida(50);

        assertTrue(plazaCentral.tieneEstaVida(400));

        jugadorDePrueba.reparar(aldeanoAliado, new Posicion(5, 5));

        aldeanoAliado.actualizarEntreTurnos();

        assertTrue(plazaCentral.tieneEstaVida(425));
    }

    @Test
    public void testCrearArmaDeAsedioCorrectamente() {

        Castillo castillo = new Castillo(jugadorDePrueba);
        terreno.ocupar(new Posicion(1, 1), castillo);

        jugadorDePrueba.crearArmaDeAsedio(castillo, new Posicion(5, 5));

        assertTrue(terreno.estaOcupada(new Posicion(5, 5)));
    }


    public void testAldeanoNoPuedeConstruirORepararDosEdificiosALaVez() {
        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(4, 4), aldeano);
        jugadorDePrueba.crearPlazaCentral(aldeano, new Posicion(5, 5));
        jugadorDePrueba.crearCuartel(aldeano, new Posicion(2, 2));

        assertTrue(terreno.estaOcupada(new Posicion(5, 5)));
        assertTrue(terreno.estaOcupada(new Posicion(6, 5)));
        assertTrue(terreno.estaOcupada(new Posicion(5, 6)));
        assertTrue(terreno.estaOcupada(new Posicion(6, 6)));

        assertFalse(terreno.estaOcupada(new Posicion(2, 2)));
        assertFalse(terreno.estaOcupada(new Posicion(3, 2)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 3)));
        assertFalse(terreno.estaOcupada(new Posicion(3, 3)));

    }

    @Test
    public void testAldeanoPuedeConstruirOtroEdificioUnaVezQueTerminoSuTarea() {
        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(4, 4), aldeano);
        jugadorDePrueba.crearPlazaCentral(aldeano, new Posicion(5, 5));
        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.actualizarEntreTurnos();
        jugadorDePrueba.crearCuartel(aldeano, new Posicion(2, 2));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(2, 3)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 3)));

        assertTrue(terreno.estaOcupada(new Posicion(5, 5)));
        assertTrue(terreno.estaOcupada(new Posicion(6, 5)));
        assertTrue(terreno.estaOcupada(new Posicion(5, 6)));
        assertTrue(terreno.estaOcupada(new Posicion(6, 6)));

    }

    @Test
    public void testSeQuitaUnidadMuertaDelaPoblacion() {

        assertEquals(jugadorDePrueba.getCantidadDeHabitantes(), 0);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);
        Cuartel cuartel = aldeano.construirCuartel();
        terreno.ocupar(new Posicion(6, 6), cuartel);

        assertEquals(jugadorDePrueba.getCantidadDeHabitantes(), 1);
        assertEquals(jugadorEnemigo.getCantidadDeHabitantes(), 0);


        Aldeano aldeanoEnemigo = new Aldeano(jugadorEnemigo);
        Cuartel cuartelEnemigo = aldeanoEnemigo.construirCuartel();
        terreno.ocupar(new Posicion(1, 1), cuartelEnemigo);

        assertEquals(jugadorEnemigo.getCantidadDeHabitantes(), 1);

        cuartel.terminarConstruccion();

        cuartelEnemigo.terminarConstruccion();

        jugadorDePrueba.crearArquero(cuartel, new Posicion(5, 5));
        jugadorEnemigo.crearEspadachin(cuartelEnemigo, new Posicion(3, 3));

        assertEquals(jugadorDePrueba.getCantidadDeHabitantes(), 2);
        assertEquals(jugadorEnemigo.getCantidadDeHabitantes(), 2);

        Arquero arqueroAliado = (Arquero) terreno.obtenerEntidadEnPosicion(new Posicion(5, 5));
        Espadachin espadachinEnemigo = (Espadachin) terreno.obtenerEntidadEnPosicion(new Posicion(3, 3));

        espadachinEnemigo.restarVida(99);

        jugadorDePrueba.atacar(arqueroAliado, new Posicion(3, 3));

        assertEquals(jugadorEnemigo.getCantidadDeHabitantes(), 1);


    }

    @Test
    public void sePuedeVolverACrearUnEdificioLuegoDeHaberFalladoLaPrimeraVez() {
        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), aldeano);

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));

        jugadorDePrueba.crearCuartel(aldeano, new Posicion(1, 1));

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 1)));
        assertFalse(terreno.estaOcupada(new Posicion(1, 2)));
        assertFalse(terreno.estaOcupada(new Posicion(2, 2)));

        jugadorDePrueba.crearPlazaCentral(aldeano, new Posicion(2, 2));

        assertTrue(terreno.estaOcupada(new Posicion(2, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(2, 3)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 2)));
        assertTrue(terreno.estaOcupada(new Posicion(3, 3)));
    }
}
