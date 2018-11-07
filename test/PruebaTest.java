import static org.junit.jupiter.api.Assertions.*;

import main.Aldeano;
import org.junit.jupiter.api.Test;

class AldeanoTest {

	@Test
	void test() {
		//Todavía no hay tests.
		Aldeano aldeano = new Aldeano();

		assert (aldeano.getVida() == 50);
		assert (aldeano.getCosto() == 25);
	}

}
