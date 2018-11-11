package algoempires;

import algoempires.entidad.edificio.Edificio;
import org.junit.Test;
import algoempires.entidad.unidad.Unidad;

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