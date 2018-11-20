package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.tablero.PosicionInvalidaException;


public abstract class Unidad extends Entidad {

    private boolean movioEsteTurno;

    public Unidad() throws PosicionInvalidaException {
        super();
        this.movioEsteTurno = false;
    }

    public boolean seMovioEnEsteTurno() {
        return this.movioEsteTurno;
    }

    public void seMovio() {
        this.movioEsteTurno = true;
    }
}
