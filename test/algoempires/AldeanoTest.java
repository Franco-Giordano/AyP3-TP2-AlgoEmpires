package algoempires;

import algoempires.entidad.unidad.utilero.Aldeano;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AldeanoTest {

	@Test
	public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {
		//Todavía no hay tests.
		Aldeano aldeano = new Aldeano();

		assertEquals(aldeano.getVida(),50);
		assertEquals(aldeano.getCosto(),25);

	}

}
