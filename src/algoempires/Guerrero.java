package algoempires;

public class Guerrero extends Unidad {

	private int rangoDelGuerrero;
	
	public Guerrero(int vidaRecibida, int costoRecibido, int rangoRecibido) {
		super(vidaRecibida, costoRecibido);
		this.rangoDelGuerrero= rangoRecibido;
	}
	
}
