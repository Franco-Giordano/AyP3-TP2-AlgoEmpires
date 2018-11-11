package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.unidad.Unidad;

public abstract class Guerrero extends Unidad {

	private int rangoDelGuerrero;
	
	public Guerrero(int vidaRecibida, int costoRecibido, int rangoRecibido) {
		super(vidaRecibida, costoRecibido);
		this.rangoDelGuerrero= rangoRecibido;
	}
	
	
	public boolean tieneRangoSuficiente(int coordenadaHorizontalDeAtaque, int coordenadaVerticalDeAtaque) {
		
		return this.getParcelaQueOcupo().estasAUnaDistanciaMenorQue(coordenadaHorizontalDeAtaque, coordenadaVerticalDeAtaque, rangoDelGuerrero);
	}
	
}
