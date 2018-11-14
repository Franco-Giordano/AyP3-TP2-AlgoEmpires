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
    public void test01MuevoUnAldeanoAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajo();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(2, 1)));

    }

    @Test
    public void test02MuevoUnAldeanoArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionArriba();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(2, 3)));

    }

    @Test
    public void test03MuevoUnAldeanoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionIzquierda();

        aldeano.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 2)));

    }

    @Test
    public void test04MuevoUnAldeanoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 2)));

    }

    @Test
    public void test05MuevoUnAldeanoArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionArribaIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 3)));

    }

    @Test
    public void test06MuevoUnAldeanoArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);


        Direccion direccion = new DireccionArribaDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 3)));

    }

    @Test
    public void test07MuevoUnAldeanoAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajoIzquierda();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(1, 1)));

    }

    @Test
    public void test08MuevoUnAldeanoAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        Aldeano aldeano = new Aldeano(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        aldeano.desplazarHacia(direccion);

        assertTrue(aldeano.estaEnCasillero(new Casillero(3, 1)));

    }

    @Test
    public void test09aldeanoConstruyeUnaPlaza() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(2, 2);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Casillero casilleroAConsultar = new Casillero(4, 4);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirPlazaCentral(casilleroAConstruir);

        assertTrue(terreno.estaOcupada(casilleroAConsultar));
    }

    @Test
    public void test10aldeanoConstruyeUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(2, 2);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Casillero casilleroAConsultar = new Casillero(4, 4);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirCuartel(casilleroAConstruir);

        assertTrue(terreno.estaOcupada(casilleroAConsultar));
    }

    @Test
    public void test11aldeanoReparaUnCuartel() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casilleroACrearAldeano = new Casillero(4, 5);

        Casillero casilleroAConstruir = new Casillero(3, 3);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.construirCuartel(casilleroAConstruir);

        aldeano.reparar(casilleroAConstruir);

        Cuartel cuartelAConsultar = (Cuartel) terreno.getMapa().get(casilleroAConstruir);

        assertEquals(cuartelAConsultar.getVidaActual(), 300);
    }

    @Test
    public void test12AldeanoNoSumaOroMientrasRepara() throws DimensionesInvalidasError, CasilleroInvalidoException {

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
    public void test13AldeanoSumaOroSiNoEstaReparando() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(10, 10);

        Jugador jugador = new Jugador(terreno);

        Casillero casilleroACrearAldeano = new Casillero(3, 5);

        Aldeano aldeano = new Aldeano(terreno, casilleroACrearAldeano);

        aldeano.actualizarEntreTurnos(jugador);

        assertEquals(jugador.getOro(), 20);
    }


}
