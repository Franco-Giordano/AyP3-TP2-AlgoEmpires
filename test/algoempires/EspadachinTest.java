package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EspadachinTest {

    @Test
    public void testMuevoUnEspadachinAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajo();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(2, 1)));

    }

    @Test
    public void testMuevoUnEspadachinArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(2, 3)));

    }

    @Test
    public void testMuevoUnEspadachinIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionIzquierda();

        espadachin.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 2)));

    }

    @Test
    public void testMuevoUnEspadachinDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 2)));

    }

    @Test
    public void testMuevoUnEspadachinArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionArribaIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 3)));

    }

    @Test
    public void testMuevoUnEspadachinArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);


        Direccion direccion = new DireccionArribaDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 3)));

    }

    @Test
    public void testMuevoUnEspadachinAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajoIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 1)));

    }

    @Test
    public void testMuevoUnEspadachinAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 1)));

    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testEspadachinSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Casillero casilleroACrearEspadachin = new Casillero(3, 4);

        Espadachin espadachin= new Espadachin(terreno,casilleroACrearEspadachin);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        espadachin.desplazarHacia(direccion);
    }
}
