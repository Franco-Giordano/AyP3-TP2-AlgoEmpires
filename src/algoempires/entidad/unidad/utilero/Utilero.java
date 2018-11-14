package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.entidad.unidad.Unidad;

public abstract class Utilero extends Unidad {

    public Utilero(int vidaRecibida, int costoRecibido, Casillero casillero) {
        super(vidaRecibida, costoRecibido, casillero);
    }
}
