package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ParcelaTest {

    @Test
    public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {

        Aldeano aldeano= new Aldeano();

        Parcela parcela = new Parcela();

        parcela.ocupar(aldeano);

        assertTrue(parcela.estaOcupada());

    }
}
