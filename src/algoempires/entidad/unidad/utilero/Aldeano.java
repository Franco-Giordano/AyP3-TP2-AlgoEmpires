package algoempires.entidad.unidad.utilero;

import algoempires.Coordenada;
import algoempires.entidad.unidad.utilero.Utilero;

public class Aldeano extends Utilero {

	//Hardcodeado
	private static int vidaDeAldeano = 50;
	private static int costoDeAldeano = 25;

	public Aldeano(Coordenada coordenada) {
		super(vidaDeAldeano, costoDeAldeano, coordenada);
	}

}
