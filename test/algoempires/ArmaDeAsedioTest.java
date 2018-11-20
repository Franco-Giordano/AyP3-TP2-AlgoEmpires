package algoempires;

import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArmaDeAsedioTest {


    @Test
    public void testUnidadSeMueveBienHaciaArriba() {

        Posicion posicion = new Posicion(1, 1);

        Terreno terreno = new Terreno(10, 10);

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

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

        ArmaDeAsedio unidad = new ArmaDeAsedio();

        Direccion direccion = new DireccionAbajoDerecha();

        terreno.ocupar(posicion, unidad);

        terreno.moverUnidad(posicion, direccion);

        Posicion posicionOcupada = new Posicion(3, 1);

        assertTrue(terreno.estaOcupada(posicionOcupada));
        assertFalse(terreno.estaOcupada(posicion));
    }

    /*
    @Test
    public void testArmaDeAsedioNoSeMueveSiEstaMontada() throws DimensionesInvalidasError, PosicionInvalidaException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        armaDeAsedio.montar();

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertFalse(armaDeAsedio.estaEnCasillero(new Posicion(3, 1)));
        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(2, 2)));

    }

    @Test
    public void testArmaDeAsedioSeMueveSiNoEstaMontada() throws DimensionesInvalidasError, PosicionInvalidaException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(3, 1)));
        assertFalse(armaDeAsedio.estaEnCasillero(new Posicion(2, 2)));
    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testArmaDeAsedioSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, PosicionInvalidaException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Jugador jugador = new Jugador(terreno);

        Posicion posicionACrearArmaDeAsedio = new Posicion(3, 4);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicionACrearArmaDeAsedio);

        Direccion direccion = new DireccionArriba();

        armaDeAsedio.desplazarHacia(direccion);

        armaDeAsedio.desplazarHacia(direccion);
    }

    */
}

