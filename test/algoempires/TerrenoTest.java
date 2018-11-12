package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    @Test
    public void test01TerrenoSeCreaDelTamanioCorrespondiente() {

        Terreno terreno = new Terreno(10, 10);

        assertEquals(terreno.getTamHorizontal(), 10);
        assertEquals(terreno.getTamVertical(), 10);

    }

}
