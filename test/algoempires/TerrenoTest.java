package algoempires;

import static org.junit.Assert.assertTrue;

import algoempires.entidad.unidad.utilero.Aldeano;

import org.junit.Test;

public class TerrenoTest {

	@Test
	public void test01EntidadAgregadaOcupaParcela() {
		
		Aldeano aldeano= new Aldeano();
		Terreno terreno= new Terreno(5, 5);
		
		
		int coordenadaHorizontal=3;
	
		int coordenadaVertical=2;
		
		terreno.ocuparParcela(coordenadaHorizontal, coordenadaVertical, aldeano);
		
		assertTrue(terreno.estaOcupada(coordenadaHorizontal, coordenadaVertical));
	}
}
