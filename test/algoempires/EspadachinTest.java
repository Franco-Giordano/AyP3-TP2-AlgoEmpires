package algoempires;

import algoempires.direccion.*;
import algoempires.entidad.unidad.guerrero.Espadachin;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EspadachinTest {

    @Test
    public void test01MuevoUnEspadachinAbajo() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajo();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(2, 1)));

    }

    @Test
    public void test02MuevoUnEspadachinArriba() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(2, 3)));

    }

    @Test
    public void test03MuevoUnEspadachinIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionIzquierda();

        espadachin.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 2)));

    }

    @Test
    public void test04MuevoUnEspadachinDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 2)));

    }

    @Test
    public void test05MuevoUnEspadachinArribaIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionArribaIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 3)));

    }

    @Test
    public void test06MuevoUnEspadachinArribaDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);


        Direccion direccion = new DireccionArribaDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 3)));

    }

    @Test
    public void test07MuevoUnEspadachinAbajoIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajoIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(1, 1)));

    }

    @Test
    public void test08MuevoUnEspadachinAbajoDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Espadachin espadachin = new Espadachin(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCasillero(new Casillero(3, 1)));

    }
}
