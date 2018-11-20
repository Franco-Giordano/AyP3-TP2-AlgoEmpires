package algoempires;

import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EspadachinTest {

    @Test
    public void testUnidadSeMueveBienHaciaArriba() {

        Posicion posicion = new Posicion(1, 1);

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();

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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();

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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


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

        Terreno terreno = new Terreno(10, 10);

        Espadachin unidad = new Espadachin();


        Direccion direccion = new DireccionAbajoDerecha();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(3, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    /*
    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testEspadachinSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, PosicionInvalidaException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicionACrearEspadachin = new Posicion(3, 4);

        Espadachin espadachin= new Espadachin(terreno, posicionACrearEspadachin);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        espadachin.desplazarHacia(direccion);
    }

    */
}
