package algoempires;


import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.entidad.unidad.utilero.EstadoConstruyendo;
import algoempires.entidad.unidad.utilero.EstadoRecolectandoOro;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.excepciones.UnidadNoPuedeMoverseException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class AldeanoTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Jugador jugadorEnemigo;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
        this.jugadorEnemigo = new Jugador("Juan", terreno);
        jugadorDePrueba.sumarOro(1000);
        jugadorEnemigo.sumarOro(1000);
    }

    @Test
    public void testAldeanoSeCreabien() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Posicion posicion = new Posicion(3, 3);

        terreno.ocupar(posicion, aldeano);

        assertTrue(terreno.estaOcupada(posicion));

    }

    @Test
    public void testAldeanoSeMueveBienHaciaArriba() {

        Posicion posicion = new Posicion(1, 1);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionArriba();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaAbajo() {

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionAbajo();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaIzquierda() {

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionIzquierda();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaDerecha() {

        Posicion posicion = new Posicion(1, 1);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionDerecha();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaArribaIzquierda() {

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionArribaIzquierda();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 3);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaArribaDerecha() {

        Posicion posicion = new Posicion(1, 1);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionArribaDerecha();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaAbajoIzquierda() {

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionAbajoIzquierda();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testAldeanoSeMueveBienHaciaAbajoDerecha() {

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Direccion direccion = new DireccionAbajoDerecha();

        terreno.ocupar(posicion, aldeano);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(3, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testaldeanoCreaUnaPlaza() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        jugadorDePrueba.sumarOro(1000);

        PlazaCentral plazaCentral = aldeano.construirPlazaCentral();

        assertNotNull(plazaCentral);
    }

    @Test
    public void testaldeanoConstruyeUnCuartel() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Cuartel cuartel = aldeano.construirCuartel();

        assertNotNull(cuartel);
    }

    @Test
    public void testAldeanoNoReparaUnCuartelConVidaLlena() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Cuartel cuartel = aldeano.construirCuartel();

        aldeano.actualizarEntreTurnos();

        aldeano.actualizarEntreTurnos();

        aldeano.actualizarEntreTurnos();

        terreno.ocupar(new Posicion(1, 1), cuartel);

        terreno.ocupar(new Posicion(3, 3), aldeano);

        aldeano.ordenarReparacion(cuartel);

        aldeano.actualizarEntreTurnos();

        assertEquals(terreno.getVida(new Posicion(1, 1)), 250);

    }


    @Test
    public void testAldeanoNoSumaOroMientrasRepara() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Cuartel cuartel = aldeano.construirCuartel();

        terreno.ocupar(new Posicion(5, 5), aldeano);

        terreno.ocupar(new Posicion(3, 3), cuartel);

        aldeano.ordenarReparacion(cuartel);

        aldeano.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 1025);
    }

    @Test
    public void testAldeanoSumaOroSiEstaReparando() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        aldeano.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 1095);
    }

    @Test(expected = UnidadNoPuedeMoverseException.class)
    public void testAldeanoSeMueveUnaSolaVezPorTurno() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(4, 4), aldeano);

        terreno.moverUnidad(new Posicion(4, 4), new DireccionArriba());

        terreno.moverUnidad(new Posicion(4, 5), new DireccionArriba());
    }

    @Test
    public void testAldeanoLasAccionesSeHacenEnElPropioTurno() {


        Aldeano aldeano1 = new Aldeano(jugadorDePrueba);
        Aldeano aldeano2 = new Aldeano(jugadorEnemigo);

        terreno.ocupar(new Posicion(3, 4), aldeano1);
        terreno.ocupar(new Posicion(5, 6), aldeano2);

        aldeano1.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 1095);
        assertEquals(jugadorEnemigo.getOro(), 1075);

        aldeano2.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 1095);
        assertEquals(jugadorEnemigo.getOro(), 1095);
    }

    @Test
    public void testAldeanoSeCreaRecolectandoOro() {

        Aldeano aldeano1 = new Aldeano(jugadorDePrueba);
        Aldeano aldeano2 = new Aldeano(jugadorEnemigo);

        EstadoRecolectandoOro estado = new EstadoRecolectandoOro(aldeano2);
        assertEquals(aldeano1.getEstadoActual().getClass(), estado.getClass());
    }

    @Test
    public void testAldeanoNoSePoneEnEstadoDeConstruccionSiNoEstanDadasLasCondiciones() {
        Aldeano aldeano1 = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(1, 1), aldeano1);

        Aldeano aldeano2 = new Aldeano(jugadorEnemigo);
        terreno.ocupar(new Posicion(9, 9), aldeano2);

        EstadoRecolectandoOro estado = new EstadoRecolectandoOro(aldeano2);
        assertEquals(aldeano1.getEstadoActual().getClass(), estado.getClass());

        jugadorDePrueba.crearCuartel(aldeano1, new Posicion(1, 1));

        assertEquals(aldeano1.getEstadoActual().getClass(), estado.getClass());
    }

    @Test
    public void testAldeanoSePoneEnEstadoDeConstruccionSiEstanDadasLasCondiciones() {
        Aldeano aldeano1 = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(1, 1), aldeano1);

        Aldeano aldeano2 = new Aldeano(jugadorEnemigo);
        terreno.ocupar(new Posicion(9, 9), aldeano2);

        Cuartel cuartelGenerico = new Cuartel();

        EstadoRecolectandoOro estado1 = new EstadoRecolectandoOro(aldeano2);

        assertEquals(aldeano1.getEstadoActual().getClass(), estado1.getClass());

        EstadoConstruyendo estado2 = new EstadoConstruyendo(aldeano2, cuartelGenerico);

        jugadorDePrueba.crearCuartel(aldeano1, new Posicion(2, 2));

        assertEquals(aldeano1.getEstadoActual().getClass(), estado2.getClass());
    }


}