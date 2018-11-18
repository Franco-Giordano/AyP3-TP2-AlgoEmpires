package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.DimensionesInvalidasError;
import algoempires.tablero.Terreno;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() throws DimensionesInvalidasError, CasilleroInvalidoException {

        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(3, 3);

        Posicion posicionACrearArmaDeAsedio = new Posicion(7, 7);

        Castillo castillo = new Castillo(terreno, posicion);

        castillo.crearArmaDeAsedio(posicionACrearArmaDeAsedio);

        assertTrue(terreno.estaOcupada(posicionACrearArmaDeAsedio));
    }

    @Test
    public void testCastilloAsignaCorrectamenteSusCaracteristicas() throws CasilleroInvalidoException, DimensionesInvalidasError {

        //TODO terminar prueba
        Terreno terreno = new Terreno(10, 10);

        Posicion posicion = new Posicion(3, 3);

       new Castillo(terreno, posicion);

    }

}
