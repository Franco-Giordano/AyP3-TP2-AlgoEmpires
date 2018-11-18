/*package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class AldeanoTest {

    @Test
    public void testAldeanoSeCreaBien() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicion = new Posicion(2,2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        assertTrue(aldeano.tieneEstasCaracteristicas(50,20,false));
    }

    @Test
    public void testMuevoUnAldeanoAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionAbajo();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(2, 1)));

    }

    @Test
    public void testMuevoUnAldeanoArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(2, 3)));

    }

    @Test
    public void testMuevoUnAldeanoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(1, 2)));

    }

    @Test
    public void testMuevoUnAldeanoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(3, 2)));

    }

    @Test
    public void testMuevoUnAldeanoArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionArribaIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(1, 3)));

    }

    @Test
    public void testMuevoUnAldeanoArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionArribaDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(3, 3)));

    }

    @Test
    public void testMuevoUnAldeanoAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionAbajoIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(1, 1)));

    }

    @Test
    public void testMuevoUnAldeanoAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        Aldeano aldeano = new Aldeano(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Posicion(3, 1)));

    }

    @Test
    public void testaldeanoConstruyeUnaPlaza() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicionACrearAldeano = new Posicion(2, 2);

        Posicion posicionAConstruir = new Posicion(3, 3);

        Posicion posicionAConsultar = new Posicion(4, 4);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        aldeano.construirPlazaCentral(posicionAConstruir);

        assertTrue(terreno.estaOcupada(posicionAConsultar));
    }

    @Test
    public void testaldeanoConstruyeUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicionACrearAldeano = new Posicion(2, 2);

        Posicion posicionAConstruir = new Posicion(3, 3);

        Posicion posicionAConsultar = new Posicion(4, 4);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        aldeano.construirCuartel(posicionAConstruir);

        assertTrue(terreno.estaOcupada(posicionAConsultar));
    }

    @Test
    public void testaldeanoReparaUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicionACrearAldeano = new Posicion(4, 5);

        Posicion posicionAConstruir = new Posicion(3, 3);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        aldeano.construirCuartel(posicionAConstruir);

        aldeano.reparar(posicionAConstruir);

        assertTrue(terreno.compararVidaDe(posicionAConstruir, 300));
    }

    @Test
    public void testAldeanoNoSumaOroMientrasRepara() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        Posicion posicionACrearAldeano = new Posicion(4, 5);

        Posicion posicionAConstruir = new Posicion(1, 3);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        aldeano.construirCuartel(posicionAConstruir);

        aldeano.reparar(posicionAConstruir);

        aldeano.actualizarEntreTurnos(jugador);

        assertEquals(jugador.getOro(), 0);

    }

    @Test
    public void testAldeanoSumaOroSiNoEstaReparando() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        Posicion posicionACrearAldeano = new Posicion(3, 5);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        aldeano.actualizarEntreTurnos(jugador);

        assertEquals(jugador.getOro(), 20);
    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testAldeanoSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Posicion posicionACrearAldeano = new Posicion(3, 4);

        Aldeano aldeano = new Aldeano(terreno, posicionACrearAldeano);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        aldeano.desplazarHacia(direccion);
    }


    @Test
    public void testAldeanoLasAccionesSeHacenEnElPropioTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException{

        Terreno terreno = new Terreno(10,10);

        Posicion posicion1 = new Posicion(3, 4);
        Posicion posicion2 = new Posicion(6, 6);

        Jugador jugador1= new Jugador(terreno);
        Jugador jugador2= new Jugador(terreno);
        jugador1.setContrincante(jugador2);
        jugador2.setContrincante(jugador1);

        Aldeano aldeano1= new Aldeano(terreno, posicion1);
        Aldeano aldeano2= new Aldeano(terreno, posicion2);

        aldeano1.actualizarEntreTurnos(jugador1);

        assertEquals(jugador1.getOro(), 20);
        assertEquals(jugador2.getOro(),0);

        aldeano2.actualizarEntreTurnos(jugador2);

        assertEquals(jugador1.getOro(), 20);
        assertEquals(jugador2.getOro(),20);

    }


}*/
