/*package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.tablero.Posicion;
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

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionAbajo();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(2, 1)));

    }

    @Test
    public void testMuevoUnEspadachinArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(2, 3)));

    }

    @Test
    public void testMuevoUnEspadachinIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionIzquierda();

        espadachin.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(espadachin.estaEnCasillero(new Posicion(1, 2)));

    }

    @Test
    public void testMuevoUnEspadachinDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(3, 2)));

    }

    @Test
    public void testMuevoUnEspadachinArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionArribaIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(1, 3)));

    }

    @Test
    public void testMuevoUnEspadachinArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);


        Direccion direccion = new DireccionArribaDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(3, 3)));

    }

    @Test
    public void testMuevoUnEspadachinAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionAbajoIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(1, 1)));

    }

    @Test
    public void testMuevoUnEspadachinAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Espadachin espadachin = new Espadachin(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Posicion(3, 1)));

    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testEspadachinSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicionACrearEspadachin = new Posicion(3, 4);

        Espadachin espadachin= new Espadachin(terreno, posicionACrearEspadachin);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        espadachin.desplazarHacia(direccion);
    }
}
*/