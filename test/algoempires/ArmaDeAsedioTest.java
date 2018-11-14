package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.maquina.ArmaDeAsedio;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArmaDeAsedioTest {

    @Test
    public void test01MuevoUnArmaDeAsedioAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionAbajo();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(2, 1)));

    }

    @Test
    public void test02MuevoUnArmaDeAsedioArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionArriba();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(2, 3)));

    }

    @Test
    public void test03MuevoUnArmaDeAsedioIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(1, 2)));

    }

    @Test
    public void test04MuevoUnArmaDeAsedioDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(3, 2)));

    }

    @Test
    public void test05MuevoUnArmaDeAsedioArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionArribaIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(1, 3)));

    }

    @Test
    public void test06MuevoUnArmaDeAsedioArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);


        Direccion direccion = new DireccionArribaDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(3, 3)));

    }

    @Test
    public void test07MuevoUnArmaDeAsedioAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionAbajoIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(1, 1)));

    }

    @Test
    public void test08MuevoUnArmaDeAsedioAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(3, 1)));

    }

    @Test
    public void testArmaDeAsedioNoSeMueveSiEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        armaDeAsedio.montar();

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertFalse(armaDeAsedio.estaEnCasillero(new Casillero(3, 1)));
        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(2, 2)));

    }

    @Test
    public void testArmaDeAsedioSeMueveSiNoEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(3, 1)));
        assertFalse(armaDeAsedio.estaEnCasillero(new Casillero(2, 2)));
    }
}
