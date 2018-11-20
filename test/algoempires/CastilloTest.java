package algoempires;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CastilloTest {

    @Test
    public void testCastilloCreaArmaDeAsedioCorrectamente() {

        Castillo castillo = new Castillo();

        ArmaDeAsedio asd = castillo.crearArmaDeAsedio();

        assertNotNull(asd);
    }


}

