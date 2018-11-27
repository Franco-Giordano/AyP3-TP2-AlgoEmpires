package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Jugador jugadorEnemigo;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);
        this.jugadorEnemigo= new Jugador("Juan", terreno);
    }

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() {

        jugadorDePrueba.sumarOro(1000);

        Castillo castillo = new Castillo(jugadorDePrueba);

        terreno.ocupar(new Posicion(1, 1), castillo.crearArmaDeAsedio());

        assertTrue(terreno.estaOcupada(new Posicion(1, 1)));
    }

    @Test
    public void testCastilloAtacaATodosEnRangoMenosAliados() {

        jugadorEnemigo.sumarOro(10000);

        Castillo castillo = new Castillo(jugadorDePrueba);
        terreno.ocupar(new Posicion(2, 2), castillo);

        Aldeano aldeano1 = new Aldeano(jugadorEnemigo);
        terreno.ocupar(new Posicion(1, 1), aldeano1);

        Aldeano aldeano2 = new Aldeano(jugadorEnemigo);
        terreno.ocupar(new Posicion(4, 1), aldeano2);

        Espadachin espadachin = new Espadachin(jugadorEnemigo);
        terreno.ocupar(new Posicion(1, 7), espadachin);

        Cuartel cuartel = new Cuartel(jugadorEnemigo);
        terreno.ocupar(new Posicion(7, 7), cuartel);

        Aldeano aldeanoAmigo = new Aldeano(jugadorDePrueba);
        terreno.ocupar(new Posicion(1, 2), aldeanoAmigo);

        castillo.actualizarEntreTurnos();

        assertTrue(aldeano1.tieneEstaVida(30));
        assertTrue(aldeano2.tieneEstaVida(30));
        assertTrue(espadachin.tieneEstaVida(80));
        assertTrue(cuartel.tieneEstaVida(63));
        assertTrue(aldeanoAmigo.tieneEstaVida(50));

    }

}

