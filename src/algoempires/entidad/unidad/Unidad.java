package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.tablero.CasilleroInvalidoException;


public abstract class Unidad extends Entidad {

    private boolean movioEsteTurno;

    public Unidad() throws CasilleroInvalidoException {
        super();
        this.movioEsteTurno = false;
    }


}
