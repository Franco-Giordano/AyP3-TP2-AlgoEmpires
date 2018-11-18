package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;


public abstract class Unidad extends Entidad {

    private boolean movioEsteTurno;
    private int RANGO;


    public Unidad() throws CasilleroInvalidoException {
        super();
        this.movioEsteTurno = false;
    }

    public abstract int getRango();


    public ArrayList<Posicion> generarRangoAPartirDePosicion(Posicion posicionRecibida) {
        Region region = new Region(posicionRecibida, this.getRango(), this.getRango());
        return region.generarRango(this, posicionRecibida);
    }

}
