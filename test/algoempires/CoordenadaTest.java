package algoempires;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import algoempires.direccion.Direccion;
import algoempires.direccion.DireccionArriba;

public class CoordenadaTest {

	
	@Test
	public void test01CoordenadaSeCreaCorrectamente() {
		Terreno terreno = new Terreno(10,10);
		Coordenada coordenada= new Coordenada(7, 5, terreno);
		
		assertEquals(coordenada.getCoordenadaVertical(), 7);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
		
	}
	
	@Test
	public void test02CoordenadaSeModificaCorrectamenteAlMover() throws MovimientoInvalidoException {

		Terreno terreno = new Terreno(10,10);

		Coordenada coordenada= new Coordenada(7, 5, terreno);
		
		Direccion direccionArriba= new DireccionArriba();
		
		coordenada.mover(direccionArriba);
		
		assertEquals(coordenada.getCoordenadaVertical(), 6);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
		
	}
	
	@Test
	public void test03SeGeneraMovidaCorrectamenteHaciaLaDireccion() {

		Terreno terreno = new Terreno(10,10);

		Coordenada coordenada= new Coordenada(7, 5, terreno);
		
		Direccion direccionArriba= new DireccionArriba();
		
		coordenada= coordenada.generarMovimientoHacia(direccionArriba);
		
		assertEquals(coordenada.getCoordenadaVertical(), 6);
		assertEquals(coordenada.getCoordenadaHorizontal(), 5);
	}
}
