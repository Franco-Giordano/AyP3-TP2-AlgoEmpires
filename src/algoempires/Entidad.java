package algoempires;



public abstract class Entidad {

	private int vida;
	private int costo;
	private Parcela parcelaQueOcupo;


	Entidad(int vidaRecibida, int costoRecibido){
		this.vida = vidaRecibida; 
		this.costo = costoRecibido; 
		this.parcelaQueOcupo= null;
		
	}

	public void setParcelaQueOcupo(Parcela nuevaParcelaOcupante) {
		this.parcelaQueOcupo=nuevaParcelaOcupante;
	}
	
	public Parcela getParcelaQueOcupo() {
		return this.parcelaQueOcupo;
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
