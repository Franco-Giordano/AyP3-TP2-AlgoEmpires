package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class JugadorTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;


    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador(terreno);
        jugadorDePrueba.sumarOro(10000);
    }

    @Test
    public void jugadorAtacaBienConArqueroAEdificios(){

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1,1), arquero);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(3,3),cuartel);

        jugadorDePrueba.atacar(arquero,new Posicion(3,3));

        assertTrue(cuartel.tieneEstaVida(240));
    }

    @Test
    public void jugadorAtacaBienConArqueroAUnidades(){

        Arquero arquero = new Arquero(jugadorDePrueba);

        terreno.ocupar(new Posicion(1,1), arquero);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2,2),aldeano);

        jugadorDePrueba.atacar(arquero,new Posicion(2,2));

        assertTrue(aldeano.tieneEstaVida(35));
    }

    @Test
    public void jugadorAtacaBienConEspadachinAEdificios(){

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1,1), espadachin);

        Cuartel cuartel = new Cuartel(jugadorDePrueba);

        terreno.ocupar(new Posicion(2,2),cuartel);

        jugadorDePrueba.atacar(espadachin,new Posicion(2,2));

        assertTrue(cuartel.tieneEstaVida(235));
    }

    @Test
    public void jugadorAtacaBienConEspadachinAUnidades(){

        Espadachin espadachin = new Espadachin(jugadorDePrueba);

        terreno.ocupar(new Posicion(1,1), espadachin);

        Aldeano aldeano = new Aldeano(jugadorDePrueba);

        terreno.ocupar(new Posicion(2,2),aldeano);

        jugadorDePrueba.atacar(espadachin,new Posicion(2,2));

        assertTrue(aldeano.tieneEstaVida(25));
    }


}
