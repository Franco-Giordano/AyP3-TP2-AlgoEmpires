package main;

public abstract class Unidad {

	private int vida;
	private int costo;

	public Unidad(int vidaRecibida, int costoRecibido) {
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
