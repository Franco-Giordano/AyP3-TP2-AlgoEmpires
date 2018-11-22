package algoempires;

import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.excepciones.UnidadNoPuedeMoverseException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArqueroTest {


    private Terreno terreno;
    private Jugador jugadorDePrueba;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
        jugadorDePrueba.sumarOro(10000);
    }


    @Test
    public void testSeRealizaDañoAlAtacar() {

        Arquero arquero = new Arquero(jugadorDePrueba);
        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        assertTrue(aldeano.tieneEstaVida(50));

        arquero.atacar(aldeano);

        assertTrue(aldeano.tieneEstaVida(35));
    }


    @Test
    public void testUnidadSeMueveBienHaciaArriba() {

        Posicion posicion = new Posicion(1, 1);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionArriba();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaAbajo() {

        Posicion posicion = new Posicion(2, 2);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionAbajo();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaIzquierda() {

        Posicion posicion = new Posicion(2, 2);


        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionIzquierda();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaDerecha() {

        Posicion posicion = new Posicion(1, 1);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionDerecha();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaArribaIzquierda() {

        Posicion posicion = new Posicion(2, 2);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionArribaIzquierda();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 3);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaArribaDerecha() {

        Posicion posicion = new Posicion(1, 1);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionArribaDerecha();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(2, 2);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaAbajoIzquierda() {

        Posicion posicion = new Posicion(2, 2);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionAbajoIzquierda();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(1, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test
    public void testUnidadSeMueveBienHaciaAbajoDerecha() {

        Posicion posicion = new Posicion(2, 2);

        Arquero unidad = new Arquero(jugadorDePrueba);

        Direccion direccion = new DireccionAbajoDerecha();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(3, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    @Test(expected = UnidadNoPuedeMoverseException.class)
    public void testArqueroSeMueveUnaSolaVezPorTurno() {

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), arquero);

        terreno.moverUnidad(new Posicion(1, 1), new DireccionArriba());

        terreno.moverUnidad(new Posicion(1, 2), new DireccionArriba());

    }

}

