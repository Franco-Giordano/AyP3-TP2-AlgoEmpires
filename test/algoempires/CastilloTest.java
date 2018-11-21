package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        jugador.sumarOro(1000);

        Castillo castillo = new Castillo(jugador);

        terreno.ocupar(new Posicion(1, 1), castillo.crearArmaDeAsedio());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }

    @Test
    public void testCastilloAtacaATodosEnRango() {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        jugador.sumarOro(10000);

        Castillo castillo = new Castillo(jugador);

        terreno.ocupar(new Posicion(2, 2), castillo);

        Aldeano aldeano1 = new Aldeano(jugador);
        terreno.ocupar(new Posicion(1, 1), aldeano1);

        Aldeano aldeano2 = new Aldeano(jugador);
        terreno.ocupar(new Posicion(4, 1), aldeano2);

        Espadachin espadachin = new Espadachin(jugador);
        terreno.ocupar(new Posicion(1, 7), espadachin);

        Cuartel cuartel = new Cuartel(jugador);
        terreno.ocupar(new Posicion(7, 7), cuartel);

        castillo.actualizarEntreTurnos();

        assertTrue(aldeano1.tieneEstaVida(30));
        assertTrue(aldeano2.tieneEstaVida(30));
        assertTrue(espadachin.tieneEstaVida(80));
        assertTrue(cuartel.tieneEstaVida(63));

    }

}

