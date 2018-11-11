package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class MonederoTest {

    @Test
    public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {
        Monedero monedero = new Monedero();

        monedero.sumarDinero(100);

        monedero.restarDinero(10);

        assertEquals(monedero.puedoDebitarElValor(10), true);

    }
}
