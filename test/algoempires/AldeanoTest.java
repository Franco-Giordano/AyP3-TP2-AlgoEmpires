package algoempires;

import algoempires.direccion.*;
import algoempires.entidad.unidad.utilero.Aldeano;
import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AldeanoTest {


    @Test
    public void test01MuevoUnAldeanoAbajo() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero coordenada = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionAbajo();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(3, 2, terreno)));

    }

    @Test
    public void test02MuevoUnAldeanoArriba() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(1, 2, terreno)));

    }

    @Test
    public void test03MuevoUnAldeanoIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionIzquierda();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(2, 1, terreno)));

    }

    @Test
    public void test04MuevoUnAldeanoDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionDerecha();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(2, 3, terreno)));

    }

    @Test
    public void test05MuevoUnAldeanoArribaIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionArribaIzquierda();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(1, 1, terreno)));

    }

    @Test
    public void test06MuevoUnAldeanoArribaDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionArribaDerecha();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(1, 3, terreno)));

    }

    @Test
    public void test07MuevoUnAldeanoAbajoIzquierda() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionAbajoIzquierda();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(3, 1, terreno)));

    }

    @Test
    public void test08MuevoUnAldeanoAbajoDerecha() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(2, 2, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionAbajoDerecha();

        aldeano.desplazarHacia(direccion);

        TestCase.assertTrue(aldeano.estaEnCoordenada(new Coordenada(3, 3, terreno)));

    }

    @Test
    public void test09ElAldeanoOcupaElEspacioCorrespondienteEnTerreno() {

        Terreno terreno = new Terreno(5, 5);

        Coordenada coordenada = new Coordenada(1, 1, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        assertTrue(terreno.estaOcupada(1, 1));
    }

    @Test(expected = CasilleroInvalidoException.class)
    public void test010AldeanoNoPuedeMoverseFueraDeRango() throws CasilleroInvalidoException {

        Terreno terreno = new Terreno(5, 5);

        Coordenada coordenada = new Coordenada(0, 0, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        aldeano.desplazarHacia(new DireccionArriba());
    }

}
