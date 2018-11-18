/*
package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ArqueroTest {

    @Test
    public void testArqueroSeCreaBien() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicion = new Posicion(2,2);

        Arquero arquero = new Arquero(terreno, posicion);

        assertTrue(arquero.tieneEstasCaracteristicas(75,3,15,10));

    }

    @Test
    public void testMuevoUnArqueroAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionAbajo();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(2, 1)));

    }

    @Test
    public void testMuevoUnArqueroArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionArriba();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(2, 3)));

    }

    @Test
    public void testMuevoUnArqueroIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionIzquierda();

        arquero.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(arquero.estaEnCasillero(new Posicion(1, 2)));

    }

    @Test
    public void testMuevoUnArqueroDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(3, 2)));

    }

    @Test
    public void testMuevoUnArqueroArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionArribaIzquierda();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(1, 3)));

    }

    @Test
    public void testMuevoUnArqueroArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);


        Direccion direccion = new DireccionArribaDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(3, 3)));

    }

    @Test
    public void testMuevoUnArqueroAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionAbajoIzquierda();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(1, 1)));

    }

    @Test
    public void testMuevoUnArqueroAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Arquero arquero = new Arquero(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCasillero(new Posicion(3, 1)));

    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testArqueroSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicionACrearArquero = new Posicion(3, 4);

        Arquero arquero= new Arquero(terreno, posicionACrearArquero);

        Direccion direccion = new DireccionArriba();

        arquero.desplazarHacia(direccion);

        arquero.desplazarHacia(direccion);
    }
}

*/
