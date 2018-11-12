package algoempires;

import algoempires.entidad.edificio.Edificio;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EdificioTest {

    @Test
    public void test01CreoUnEdificio() {

        Terreno terreno = new Terreno(10, 10);

        Coordenada coordenada = new Coordenada(5, 5, terreno);

        Region tamanio = terreno.obtenerAdyacentesA(coordenada);

        Edificio edificio = new Edificio(10, 10, 1, tamanio);

        assertTrue(terreno.estaOcupada(4, 4));
        assertTrue(terreno.estaOcupada(5, 5));
        assertTrue(terreno.estaOcupada(6, 6));

    }
}
