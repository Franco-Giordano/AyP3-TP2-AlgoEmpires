package algoempires;


import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.UnidadNoPuedeMoverseException;
import algoempires.entidad.unidad.utilero.Aldeano;
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

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
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
    public void testAldeanoReparaUnCuartel() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Cuartel cuartel = aldeano.construirCuartel();

        terreno.ocupar(new Posicion(1, 1), cuartel);

        terreno.ocupar(new Posicion(3, 3), aldeano);

        aldeano.reparar(cuartel);

        assertTrue(terreno.compararVidaDe(new Posicion(2, 2), 300));

    }

    @Test
    public void testAldeanoNoSumaOroMientrasRepara() {

        Jugador jugador = new Jugador(terreno);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        Cuartel cuartel = aldeano.construirCuartel();

        terreno.ocupar(new Posicion(5, 5), aldeano);

        terreno.ocupar(new Posicion(3, 3), cuartel);

        aldeano.reparar(cuartel);

        aldeano.actualizarEntreTurnos();

        assertEquals(jugador.getOro(), 100);
    }

    @Test
    public void testAldeanoSumaOroSiEstaReparando() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        aldeano.actualizarEntreTurnos();

        assertEquals(jugadorDePrueba.getOro(), 95);
    }

    //TODO por ahora las unidades se pueden mover 2 veces, CORREGIR.
    @Test(expected = UnidadNoPuedeMoverseException.class)
    public void testAldeanoSeMueveUnaSolaVezPorTurno() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(4, 4), aldeano);

        terreno.moverUnidad(new Posicion(4, 4), new DireccionArriba());

        terreno.moverUnidad(new Posicion(4, 5), new DireccionArriba());
    }

    @Test
    public void testAldeanoLasAccionesSeHacenEnElPropioTurno() {

        Jugador jugador1 = new Jugador(terreno);
        Jugador jugador2 = new Jugador(terreno);
        jugador1.setContrincante(jugador2);
        jugador2.setContrincante(jugador1);

        Aldeano aldeano1 = new Aldeano(jugador1);
        Aldeano aldeano2 = new Aldeano(jugador2);

        terreno.ocupar(new Posicion(3, 4), aldeano1);
        terreno.ocupar(new Posicion(5, 6), aldeano2);

        aldeano1.actualizarEntreTurnos();

        assertEquals(jugador1.getOro(), 95);
        assertEquals(jugador2.getOro(), 75);

        aldeano2.actualizarEntreTurnos();

        assertEquals(jugador1.getOro(), 95);
        assertEquals(jugador2.getOro(), 95);
    }

}