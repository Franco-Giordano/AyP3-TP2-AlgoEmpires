package algoempires;

import algoempires.direccion.Direccion;
import algoempires.direccion.DireccionAbajo;
import algoempires.entidad.unidad.utilero.Aldeano;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AldeanoTest {

	@Test
	public void test01MuevoUnAldeano() {

	    Terreno terreno  = new Terreno(10,10);

	    Coordenada coordenada = new Coordenada(1,1, terreno);

	    Aldeano aldeano = new Aldeano(coordenada);

        Direccion direccion = new DireccionAbajo();

	    aldeano.desplazarHacia(direccion);

	    assertTrue(aldeano.estaEnCoordenada(new Coordenada(2,1,terreno)));

	}

}
