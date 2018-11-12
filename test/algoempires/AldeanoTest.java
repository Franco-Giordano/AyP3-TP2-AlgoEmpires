package algoempires;

import algoempires.direccion.Direccion;
import algoempires.direccion.DireccionAbajo;
import algoempires.entidad.unidad.utilero.Aldeano;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AldeanoTest {

	@Test
	public void test01MuevoUnAldeano() {

	    Terreno terreno  = new Terreno(10,10);

	    Coordenada coordenada = new Coordenada(1,1, terreno);

	    Aldeano aldeano = new Aldeano(coordenada);

        aldeano.imprimirPosicion();

        Direccion direccion = new DireccionAbajo();

	    aldeano.desplazarHacia(direccion);

	    aldeano.imprimirPosicion();

	    assertTrue(aldeano.estaEnCoordenada(new Coordenada(1,2,terreno)));

	}

}
