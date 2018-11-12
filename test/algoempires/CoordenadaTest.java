package algoempires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algoempires.direccion.Direccion;
import algoempires.direccion.DireccionArriba;

public class CoordenadaTest {

	
	@Test
	public void test01CoordenadaSeCreaCorrectamente() {
		Coordenada coordenada= new Coordenada(7, 5, null);
		
		assertEquals(coordenada.getCoordenadaVertical(), 7);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
		
	}
	
	@Test
	public void test02CoordenadaSeModificaCorrectamenteAlMover() {
		
		Coordenada coordenada= new Coordenada(7, 5, null);
		
		Direccion direccionArriba= new DireccionArriba();
		
		coordenada.mover(direccionArriba);
		
		assertEquals(coordenada.getCoordenadaVertical(), 6);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
		
	}
	
	@Test
	public void test03SeGeneraMovidaCorrectamenteHaciaLaDireccion() {
		
		Coordenada coordenada= new Coordenada(7, 5, null);
		
		Direccion direccionArriba= new DireccionArriba();
		
		coordenada= coordenada.generarMovidaHacia(direccionArriba);
		
		assertEquals(coordenada.getCoordenadaVertical(), 6);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
	}
}
