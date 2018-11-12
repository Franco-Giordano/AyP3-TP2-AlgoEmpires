package algoempires.entidad.unidad.utilero;

import algoempires.Coordenada;
import algoempires.entidad.unidad.Unidad;

public abstract class Utilero extends Unidad {

    public Utilero(int vidaRecibida, int costoRecibido, Coordenada coordenada) {
        super(vidaRecibida, costoRecibido, coordenada);
    }
}
