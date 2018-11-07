package algoempires;

public class Edificio extends Entidad{

	private int turnosDeConstruccion;
	private int tamanio;

	public Edificio(int vidaRecibida, int costoRecibido, int turnosDeConstruccionRecibidos, int tamanioRecibido) {
		super(vidaRecibida, costoRecibido);
		this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
		this.tamanio = tamanioRecibido;
	}

	//----------------------------------------------------------------------------------------------------------------//
	//######################################### METODOS DE TESTEO ####################################################//
	//----------------------------------------------------------------------------------------------------------------//

	public int getTurnosDeConstruccion() {
		return turnosDeConstruccion;
	}

	public int getTamanio() {
		return tamanio;
	}
}
