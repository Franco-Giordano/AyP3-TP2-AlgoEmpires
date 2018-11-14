package algoempires;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
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

        Casillero casillero = new Casillero(2,2);

        Aldeano aldeano = new Aldeano(terreno,casillero);

        

    }

    @Test
    public void testMuevoUnAldeanoAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajo();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(2, 1)));

    }

    @Test
    public void testMuevoUnAldeanoArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(2, 3)));

    }

    @Test
    public void testMuevoUnAldeanoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionIzquierda();

        aldeano.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 2)));

    }

    @Test
    public void testMuevoUnAldeanoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 2)));

    }

    @Test
    public void testMuevoUnAldeanoArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionArribaIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 3)));

    }

    @Test
    public void testMuevoUnAldeanoArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);


        Direccion direccion = new DireccionArribaDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 3)));

    }

    @Test
    public void testMuevoUnAldeanoAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajoIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 1)));

    }

    @Test
    public void testMuevoUnAldeanoAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 1)));

    }

    @Test
    public void testaldeanoConstruyeUnaPlaza() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(2, 2);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Casillero casilleroAConsultar = new Casillero(4, 4);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirPlazaCentral(casilleroAConstruir);

        assertTrue(terreno.estaOcupada(casilleroAConsultar));
    }

    @Test
    public void testaldeanoConstruyeUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(2, 2);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Casillero casilleroAConsultar = new Casillero(4, 4);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirCuartel(casilleroAConstruir);

        assertTrue(terreno.estaOcupada(casilleroAConsultar));
    }

    @Test
    public void testaldeanoReparaUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(4, 5);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirCuartel(casilleroAConstruir);

        aldeano.reparar(casilleroAConstruir);

        assertTrue(terreno.compararVidaDe(casilleroAConstruir, 300));
    }

    @Test
    public void testAldeanoNoSumaOroMientrasRepara() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        Casillero casilleroACrearAldeano = new Casillero(4, 5);

        Casillero casilleroAConstruir = new Casillero(1, 3);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirCuartel(casilleroAConstruir);

        aldeano.reparar(casilleroAConstruir);

        aldeano.actualizarEntreTurnos(jugador);

        assertEquals(jugador.getOro(), 0);

    }

    @Test
    public void testAldeanoSumaOroSiNoEstaReparando() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        Casillero casilleroACrearAldeano = new Casillero(3, 5);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.actualizarEntreTurnos(jugador);

        assertEquals(jugador.getOro(), 20);
    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testAldeanoSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Casillero casilleroACrearAldeano = new Casillero(3, 4);

        Aldeano aldeano = new Aldeano(terreno,casilleroACrearAldeano);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        aldeano.desplazarHacia(direccion);
    }


}
