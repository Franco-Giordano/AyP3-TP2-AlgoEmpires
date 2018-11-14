package algoempires;

import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;
import algoempires.entidad.unidad.maquina.ArmaDeAsedio;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;
import algoempires.tablero.direccion.DireccionAbajoDerecha;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArmaDeAsedioTest {

    @Test
    public void testArmaDeAsedioNoSeMueveSiEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        armaDeAsedio.montar();

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertFalse(armaDeAsedio.estaEnCasillero(new Casillero(3, 1)));
        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(2, 2)));

    }

    @Test
    public void testArmaDeAsedioSeMueveSiNoEstaMontada() throws DimensionesInvalidasError, CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(2, 2);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(terreno, casillero);

        Direccion direccion = new DireccionAbajoDerecha();

        armaDeAsedio.desplazarHacia(direccion);

        assertTrue(armaDeAsedio.estaEnCasillero(new Casillero(3, 1)));
        assertFalse(armaDeAsedio.estaEnCasillero(new Casillero(2, 2)));
    }
}
