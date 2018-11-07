package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EdificioTest {

    @Test
    public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {
        Edificio edificio = new Edificio(10,10,10,10);

        assertEquals(edificio.getVida(),10);
        assertEquals(edificio.getCosto(),10);
        assertEquals(edificio.getTamanio(),10);
        assertEquals(edificio.getTurnosDeConstruccion(),10);

    }
}
