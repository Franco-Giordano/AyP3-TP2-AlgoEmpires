package algoempires;

import algoempires.direccion.*;
import algoempires.entidad.unidad.guerrero.Arquero;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ArqueroTest {

    @Test
    public void test01MuevoUnArqueroAbajo() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionAbajo();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(3, 2, terreno)));

    }

    @Test
    public void test02MuevoUnArqueroArriba() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionArriba();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(1, 2, terreno)));

    }

    @Test
    public void test03MuevoUnArqueroIzquierda() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionIzquierda();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(2, 1, terreno)));

    }

    @Test
    public void test04MuevoUnArqueroDerecha() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(2, 3, terreno)));

    }

    @Test
    public void test05MuevoUnArqueroArribaIzquierda() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionArribaIzquierda();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(1, 1, terreno)));

    }

    @Test
    public void test06MuevoUnArqueroArribaDerecha() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionArribaDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(1, 3, terreno)));

    }

    @Test
    public void test07MuevoUnArqueroAbajoIzquierda() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionAbajoIzquierda();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(3, 1, terreno)));

    }

    @Test
    public void test08MuevoUnArqueroAbajoDerecha() throws MovimientoInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Arquero arquero = new Arquero(coordenada);

        Direccion direccion = new DireccionAbajoDerecha();

        arquero.desplazarHacia(direccion);

        assertTrue(arquero.estaEnCoordenada(new Coordenada(3, 3, terreno)));

    }
}
