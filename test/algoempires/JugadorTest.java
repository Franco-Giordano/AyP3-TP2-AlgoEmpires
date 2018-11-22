package algoempires;

import algoempires.entidad.Entidad;
import algoempires.entidad.EntidadFueraDeRangoException;
import algoempires.entidad.NoSeToleraFuegoAmigoException;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedioNoPuedeAtacarUnidadesException;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JugadorTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Jugador jugadorEnemigo;


    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
        this.jugadorEnemigo = new Jugador(terreno);
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

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConArqueroPorDistanciaDeLaUnidadTest() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(9, 9), aldeano);

        jugadorDePrueba.atacar(arquero, new Posicion(9, 9));

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

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConEspadachinPorDistanciaDeLaUnidadTest() {

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(3, 3), aldeano);

        jugadorDePrueba.atacar(espadachin, new Posicion(3, 3));

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

    @Test(expected = EntidadFueraDeRangoException.class)
    public void jugadorNoPuedeAtacarConArmaDeAsedioPorDistanciaDeLEdificioTest() {

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), armaDeAsedio);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);

        terreno.ocupar(new Posicion(7, 7), cuartel);

        jugadorDePrueba.atacar(armaDeAsedio, new Posicion(7, 7));

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

        jugadorDePrueba.crearAldeano(plazaCentral, posicion);

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 9995);

        jugadorDePrueba.informarDestruccion((Unidad) terreno.obtenerEntidadEnPosicion(new Posicion(1, 3)));

        jugadorDePrueba.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 10015);

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
    public void testJugadorCreaPlazaCentralCorrectamente(){

        Aldeano aldeano= new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4,4), aldeano);
        Posicion posicionDeLaPlaza= new Posicion(5,5);

        assertFalse(terreno.estaOcupada(posicionDeLaPlaza));
        assertFalse(terreno.estaOcupada(new Posicion(6,6)));
        assertFalse(terreno.estaOcupada(new Posicion(5,6)));

        jugadorDePrueba.crearPlazaCentral(aldeano, posicionDeLaPlaza);

        assertTrue(terreno.estaOcupada(posicionDeLaPlaza));
        assertTrue(terreno.estaOcupada(new Posicion(6,6)));
        assertTrue(terreno.estaOcupada(new Posicion(5,6)));
    }

    @Test
    public void testJugadorCreaCuartelCorrectamente(){

        Aldeano aldeano= new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4,4), aldeano);


        assertFalse(terreno.estaOcupada(new Posicion(5,5)));
        assertFalse(terreno.estaOcupada(new Posicion(6,6)));
        assertFalse(terreno.estaOcupada(new Posicion(5,6)));

        jugadorDePrueba.crearCuartel(aldeano, new Posicion(5,5));

        assertTrue(terreno.estaOcupada(new Posicion(5,5)));
        assertTrue(terreno.estaOcupada(new Posicion(6,6)));
        assertTrue(terreno.estaOcupada(new Posicion(5,6)));
    }

    @Test
    public void testEdificioSeReparaCorrectamente(){

        Aldeano aldeanoAliado= new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(4,4), aldeanoAliado);

        Cuartel cuartel= new Cuartel(jugadorDePrueba);
        terreno.ocupar(new Posicion(5,5), cuartel);

        cuartel.actualizarEntreTurnos();
        cuartel.actualizarEntreTurnos();
        cuartel.actualizarEntreTurnos();
        cuartel.actualizarEntreTurnos();

        assertTrue(cuartel.tieneEstaVida(250));

        cuartel.restarVida(50);

        assertTrue(cuartel.tieneEstaVida(200));

        jugadorDePrueba.reparar(aldeanoAliado, new Posicion(5,5));

        aldeanoAliado.actualizarEntreTurnos();

        assertTrue(cuartel.tieneEstaVida(250));
    }

    @Test
    public void testCrearArmaDeAsedioCorrectamente(){

        Castillo castillo= new Castillo(jugadorDePrueba);
        terreno.ocupar(new Posicion(1,1), castillo);

        jugadorDePrueba.crearArmaDeAsedio(castillo, new Posicion(5,5));

        assertTrue(terreno.estaOcupada(new Posicion(5,5)));
    }
}
