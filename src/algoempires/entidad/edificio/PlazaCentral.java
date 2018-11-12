package algoempires.entidad.edificio;

import algoempires.Region;
import algoempires.entidad.unidad.utilero.Aldeano;

public class PlazaCentral extends Edificio {

	private static int vidaDeLaPlaza=450;
	private static int costoDeLaPlaza=100;
	private static int turnosDeConstruccion=4;
	private static Region tamanio;
	
	public PlazaCentral() {	
		super(vidaDeLaPlaza, costoDeLaPlaza, turnosDeConstruccion, tamanio);
	}

}
