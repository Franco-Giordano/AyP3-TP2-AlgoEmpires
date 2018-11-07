package algoempires;

public abstract class Entidad {

	private int vida;
	private int costo;

	Entidad(int vidaRecibida, int costoRecibido){
		this.vida = vidaRecibida; 
		this.costo = costoRecibido; 
	}

	//----------------------------------------------------------------------------------------------------------------//
	//######################################### METODOS DE TESTEO ####################################################//
	//----------------------------------------------------------------------------------------------------------------//
	public int getVida(){
		return this.vida;
	}

	public int getCosto(){
		return this.costo;
	}
	
}
