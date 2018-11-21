package algoempires;

import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.jugador.Poblacion;
import algoempires.jugador.SeIntentoSuperarPoblacionMaximaException;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PoblacionTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Poblacion pueblo;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
        jugadorDePrueba.sumarOro(10000);
        this.pueblo = new Poblacion();
    }

    @Test
    public void testCrearUnidadAumentaPoblacion() {

        pueblo.agregar(new Aldeano(jugadorDePrueba));

        assertEquals(pueblo.cantidadDeUnidades(), 1);
    }

    @Test
    public void testRemoverUnidadDisminuyePoblacion() {

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        pueblo.agregar(aldeano);

        assertEquals(pueblo.cantidadDeUnidades(), 1);

        pueblo.quitar(aldeano);

        assertEquals(pueblo.cantidadDeUnidades(), 0);

    }

    @Test(expected = SeIntentoSuperarPoblacionMaximaException.class)
    public void testNoSePuedeSuperarTopePoblacional() {
        for (int i = 0; i < 51; i++) {
            pueblo.agregar(new Espadachin(jugadorDePrueba));
        }
    }

}
