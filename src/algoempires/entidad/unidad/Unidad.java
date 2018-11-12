package algoempires.entidad.unidad;

import algoempires.Coordenada;
import algoempires.MovimientoInvalidoException;
import algoempires.Posicion;
import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;


public abstract class Unidad extends Entidad {

	private Posicion posicion;

	public Unidad(int vidaRecibida, int costoRecibido, Coordenada coordenada) {
		super(vidaRecibida, costoRecibido);
		this.posicion = new Posicion(coordenada);
		this.posicion.ocupar(this);
	}

	public void desplazarHacia(Direccion direccion) throws MovimientoInvalidoException {
		posicion.desplazarHacia(direccion);

	}

    public boolean estaEnCoordenada(Coordenada coordenada) {
	    return this.posicion.estaEn(coordenada);
    }

}
