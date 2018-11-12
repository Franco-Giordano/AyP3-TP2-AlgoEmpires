package algoempires;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    @Test
    public void test01TerrenoSeCreaDelTamanioCorrespondiente(){

        Terreno terreno = new Terreno(10,10);

        assertEquals(terreno.getTamanioHorizontal(), 10);
        assertEquals(terreno.getTamanioVertical(), 10);

    }

}
