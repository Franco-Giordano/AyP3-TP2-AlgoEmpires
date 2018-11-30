package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;
import algoempires.tablero.Terreno;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;


public class RegionTest {

    private Terreno terreno;
    private Jugador jugadorDePrueba;
    private Castillo castillo;
    private Region regionOcupada;

    @Before
    public void init() {
        this.terreno = new Terreno(10, 10);
        this.jugadorDePrueba = new Jugador("Carlos", terreno);

        this.castillo= new Castillo(jugadorDePrueba);
        terreno.ocupar(new Posicion(2,2), castillo);
        this.regionOcupada= castillo.getRegionQueLoContiene();
    }

    @Test
    public void testPosicionInferiorIzquierdaSeCalculaBien(){
        Posicion posInfIzq= regionOcupada.getPosicionInferiorIzquierda();
        assertEquals(new Posicion(2,2), posInfIzq);
    }

    @Test
    public void testPosicionSuperiorDerechaSeCalculaBien(){
        Posicion posSupDer= regionOcupada.getPosicionSuperiorDerecha();
        assertEquals(new Posicion(5,5), posSupDer);
    }

    @Test
    public void testRegionSeVaciaCorrectamente(){
        regionOcupada.vaciar();
        Posicion posInfIzq= regionOcupada.getPosicionInferiorIzquierda();

        for (int i = 0; i < regionOcupada.getTamanioHorizontal() ; i++) {
            for (int j = 0; j < regionOcupada.getTamanioVertical(); j++) {
                assertFalse(terreno.estaOcupada(new Posicion(i,j, posInfIzq)));
            }
        }
    }


    @Test
    public void testRegionSeCreaBien(){
        Posicion posInfIzq= regionOcupada.getPosicionInferiorIzquierda();

        for (int i = 0; i < regionOcupada.getTamanioHorizontal() ; i++) {
            for (int j = 0; j < regionOcupada.getTamanioVertical(); j++) {
                assertTrue(regionOcupada.contiene(new Posicion(i,j, posInfIzq)));
            }
        }

        assertFalse(regionOcupada.contiene(new Posicion(1,1)));
        assertFalse(regionOcupada.contiene(new Posicion(10,10)));

    }
}
