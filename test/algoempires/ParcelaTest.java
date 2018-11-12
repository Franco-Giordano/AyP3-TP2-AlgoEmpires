package algoempires;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algoempires.entidad.unidad.utilero.Aldeano;

public class ParcelaTest {

    @Test
    public void test01ParcelaSeCreaCorrectamente() {
        Parcela parcela = new Parcela();
        assertFalse(parcela.estaOcupada());
    }

    @Test
    public void test02ParcelaSeOcupaCorrectamente() {
        Parcela parcela = new Parcela();


        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(5, 5, terreno);

        Aldeano aldeano = new Aldeano(coordenada);

        parcela.ocupar(aldeano);

        assertTrue(parcela.estaOcupada());

    }
}
