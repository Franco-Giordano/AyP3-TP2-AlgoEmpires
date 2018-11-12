package algoempires.entidad.unidad.guerrero;

import algoempires.Coordenada;
import algoempires.entidad.unidad.guerrero.Guerrero;

public class Arquero extends Guerrero {
	
	private static int vidaDelArquero= 75;
	private static int costoDelArquero= 75;
	private static int rangoDelArquero= 3;
	
	public Arquero(Coordenada coordenada) {
		super(vidaDelArquero, costoDelArquero, rangoDelArquero, coordenada);
	}

}
