package algoempires;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AldeanoTest {

	public AldeanoTest(){

	}

	@Test
	public void test01Aldeano() {
		//Todavía no hay tests.
		Aldeano aldeano = new Aldeano();

		assertEquals(aldeano.getVida(),50);
		assertEquals(aldeano.getCosto(),25);

	}

}
