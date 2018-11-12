package algoempires.entidad.unidad;

import algoempires.Coordenada;
import algoempires.Posicion;
import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;



//TODO Hacer abstracta?
public class Unidad extends Entidad {

	private Posicion posicion;

	public Unidad(int vidaRecibida, int costoRecibido, Coordenada coordenada) {
		super(vidaRecibida, costoRecibido);
		this.posicion = new Posicion(coordenada);
	}

	public void desplazarHacia(Direccion direccion) {
		posicion.desplazarHacia(direccion);
	}

    public boolean estaEnCoordenada(Coordenada coordenada) {
	    return this.posicion.estaEn(coordenada);
    }

}
