package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() {

        Terreno terreno = new Terreno(10,10);

        Jugador jugador =new Jugador(terreno);

        jugador.sumarOro(1000);

        Castillo castillo = new Castillo(jugador);

        terreno.ocupar(new Posicion(1,1),castillo.crearArmaDeAsedio());

        assertTrue(terreno.estaOcupada(new Posicion(1,1)));
    }

}

