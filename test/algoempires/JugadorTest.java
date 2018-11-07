package algoempires;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class JugadorTest {

    @Test
    public void test01UtilizandoMetodosQueNoSeUtilizanPorAhora() {
        Jugador jugador = new Jugador();

        Edificio edificio = new Edificio(10,10,10,10);

        Unidad unidad = new Unidad(10,10);

        jugador.agregarEdificio(edificio);

        jugador.agregarUnidad(unidad);

        assertEquals(jugador.getUnidades().get(0),unidad);

    }
}