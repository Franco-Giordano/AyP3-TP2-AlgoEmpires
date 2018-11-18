/*package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;ocupar
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioSeCreaBien() throws DimensionesInvalidasError, CasilleroInvalidoException {
        Terreno terreno = new Terreno(10,10);

        Posicion posicion = new Posicion(2,2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        assertTrue(armaDeAsedio.tieneEstasCaracteristicas(150,5,1, 75, false));
    }

    @Test
    public void testMuevoUnArmaDeAsedioAbajo() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionAbajo();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(2, 1)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioArriba() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionArriba();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(2, 3)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        //El problema son las id de los casilleros. Son distintas aunque tengan las mismas coordenadas.
        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(1, 2)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(3, 2)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioArribaIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionArribaIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(1, 3)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioArribaDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);


        Direccion direccion = new DireccionArribaDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(3, 3)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioAbajoIzquierda() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionAbajoIzquierda();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(1, 1)));

    }

    @Test
    public void testMuevoUnArmaDeAsedioAbajoDerecha() throws CasilleroInvalidoException, DimensionesInvalidasError, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(3, 1)));

    }

    @Test
    public void testArmaDeAsedioNoSeMueveSiEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        armaDeAsedio.montar();

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertFalse(armaDeAsedio.estaEnCasillero(new Posicion(3, 1)));
        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(2, 2)));

    }

    @Test
    public void testArmaDeAsedioSeMueveSiNoEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicion);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Posicion(3, 1)));
        assertFalse(armaDeAsedio.estaEnCasillero(new Posicion(2, 2)));
    }

    @Test(expected = UnidadYaMovioEnEsteTurnoException.class)
    public void testArmaDeAsedioSeMueveUnaSolaVezPorTurno() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10,10);

        Jugador jugador = new Jugador(terreno);

        Posicion posicionACrearArmaDeAsedio = new Posicion(3, 4);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, posicionACrearArmaDeAsedio);

        Direccion direccion = new DireccionArriba();

        armaDeAsedio.desplazarHacia(direccion);

        armaDeAsedio.desplazarHacia(direccion);
    }
}
*/