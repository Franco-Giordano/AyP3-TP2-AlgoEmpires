package algoempires.entidad.unidad;

import algoempires.Casillero;
import algoempires.Coordenada;
import algoempires.CasilleroInvalidoException;
import algoempires.Posicion;
import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;


public abstract class Unidad extends Entidad {

    private Posicion posicion;

    public Unidad(int vidaRecibida, int costoRecibido, Casillero casillero) {
        super(vidaRecibida, costoRecibido);
        this.posicion = new Posicion(casillero);
        this.posicion.ocupar(this);
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException {
        posicion.desplazarHacia(direccion);

    }

    public boolean estaEnCoordenada(Coordenada coordenada) {
        return this.posicion.estaEn(coordenada);
    }

}
