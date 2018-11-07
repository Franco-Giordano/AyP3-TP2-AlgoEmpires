package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ParcelaTest {

    @Test
    public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {

        Unidad unidad = new Unidad(10,10);

        Parcela parcela = new Parcela();

        parcela.ocupar(unidad);

        assertEquals(parcela.estaOcupada(),true);

    }
}
