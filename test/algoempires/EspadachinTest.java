package algoempires;

import algoempires.direccion.*;
import algoempires.entidad.unidad.guerrero.Espadachin;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class EspadachinTest {

    @Test

    public void test01MuevoUnEspadachinAbajo() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionAbajo();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(3, 2, terreno)));

    }

    @Test
    public void test02MuevoUnEspadachinArriba() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionArriba();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(1, 2, terreno)));

    }

    @Test
    public void test03MuevoUnEspadachinIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(2, 1, terreno)));

    }

    @Test
    public void test04MuevoUnEspadachinDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(2, 3, terreno)));

    }

    @Test
    public void test05MuevoUnEspadachinArribaIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionArribaIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(1, 1, terreno)));

    }

    @Test
    public void test06MuevoUnEspadachinArribaDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionArribaDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(1, 3, terreno)));

    }

    @Test
    public void test07MuevoUnEspadachinAbajoIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionAbajoIzquierda();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(3, 1, terreno)));

    }

    @Test
    public void test08MuevoUnEspadachinAbajoDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Espadachin espadachin = new Espadachin(coordenada);

        Direccion direccion = new DireccionAbajoDerecha();

        espadachin.desplazarHacia(direccion);

        assertTrue(espadachin.estaEnCoordenada(new Coordenada(3, 3, terreno)));

    }
}
