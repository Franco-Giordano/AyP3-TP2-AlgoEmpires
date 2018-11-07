package algoempires;

import org.junit.Test;

import static org.testng.AssertJUnit.assertEquals;

public class AldeanoTest {

	@Test
	public void test01AldeanoSeCreaCorrectamente() {
		//Todavía no hay tests.
		Aldeano aldeano = new Aldeano();

		assertEquals(aldeano.getVida(),50);
		assertEquals(aldeano.getCosto(),25);

	}

}
