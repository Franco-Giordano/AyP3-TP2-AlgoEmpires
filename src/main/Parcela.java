package main;

public class Parcela {

	private boolean ocupada; 
	private Entidad entidadOcupante; 
	
	Parcela(){
		
		ocupada = false; 
	
	}
	
	void ocupar(Entidad entidadOcupanteRecibida) {
		
		this.entidadOcupante = entidadOcupanteRecibida;
		ocupada = true; 
	}
	
	boolean estaOcupada(){
		
		return ocupada;
		
	}
	
}
