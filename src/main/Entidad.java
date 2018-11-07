package main;

public class Entidad {

	private int vida;
	private int costo;

	Entidad(int vidaRecibida, int costoRecibido){
		this.vida = vidaRecibida; 
		this.costo = costoRecibido; 
	}
	
	public int getVida() {
		return this.vida;
	}

	public int getCosto() {
		return this.costo;
	}

	public void setVida(int nuevaVida) {
		this.setVida(nuevaVida);
	}

	public void setCosto(int nuevoCosto) {
		this.costo = nuevoCosto;
	}
	
}
