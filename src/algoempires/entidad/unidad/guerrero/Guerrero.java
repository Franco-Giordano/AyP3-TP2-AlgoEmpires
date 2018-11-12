package algoempires.entidad.unidad.guerrero;

import algoempires.Coordenada;
import algoempires.entidad.unidad.Unidad;

public abstract class Guerrero extends Unidad {

	private int rangoDelGuerrero;
	
	public Guerrero(int vidaRecibida, int costoRecibido, int rangoRecibido, Coordenada coordenada) {
		super(vidaRecibida, costoRecibido, coordenada);
		this.rangoDelGuerrero= rangoRecibido;
	}
	
	
	public boolean tieneRangoSuficiente(int coordenadaHorizontalDeAtaque, int coordenadaVerticalDeAtaque) {
		
		return this.getParcelaQueOcupo().estasAUnaDistanciaMenorQue(coordenadaHorizontalDeAtaque, coordenadaVerticalDeAtaque, rangoDelGuerrero);
	}
	
}
