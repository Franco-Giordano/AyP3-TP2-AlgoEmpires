package algoempires.entidad.unidad;

import algoempires.Posicion;
import algoempires.Region;
import algoempires.entidad.Entidad;



//TODO Hacer abstracta?
public class Unidad extends Entidad {

	private Posicion posicion;

	//TODO Constructor extraño, remover
	public Unidad(int vidaRecibida, int costoRecibido) {
		super(vidaRecibida, costoRecibido);
		this.posicion = null;
	}

	public Unidad(int vidaRecibida, int costoRecibido, Region region) {
		super(vidaRecibida, costoRecibido);
		this.posicion = new Posicion(region);
	}

	public void desplazarHaciaArribaIzquierda() {
		posicion.desplazarHaciaArribaIzquierda();
	}

	public void desplazarHaciaArribaDerecha() {

	}

	public void desplazarHaciaArriba() {

	}

	public void desplazarHaciaIzquierda() {

	}

	public void desplazarHaciaDerecha() {

	}

	public void desplazarHaciaAbajoIzquierda() {

	}

	public void desplazarHaciaAbajoDerecha() {

	}

	public void desplazarHaciaAbajo() {

	}
}
