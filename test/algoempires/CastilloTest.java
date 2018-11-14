package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Casillero casilleroACrearArmaDeAsedio = new Casillero(7, 7);

        Castillo castillo = new Castillo(terreno, casillero);

        castillo.crearArmaDeAsedio(casilleroACrearArmaDeAsedio);

        assertTrue(terreno.estaOcupada(casilleroACrearArmaDeAsedio));
    }

    @Test
    public void testCastilloAsignaCorrectamenteSusCaracteristicas() throws CasilleroInvalidoException, DimensionesInvalidasError {

        //TODO terminar prueba
        Terreno terreno = new Terreno(10, 10);

        Casillero casillero = new Casillero(3, 3);

        Castillo castillo = new Castillo(terreno, casillero);

    }

}
