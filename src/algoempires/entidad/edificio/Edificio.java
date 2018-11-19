package algoempires.entidad.edificio;

import algoempires.entidad.Entidad;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;

public abstract class Edificio extends Entidad {

    protected int TAMANIO_HORIZONTAL;
    protected int TAMANIO_VERTICAL;
    protected int VIDA_INICIAL;
    protected int VELOCIDAD_DE_REPARACION;

    private int turnosDeConstruccion;

    public Edificio() throws CasilleroInvalidoException {
        super();

        this.turnosDeConstruccion = getTurnosDeConstruccionInicial();

    }

    protected abstract int getTurnosDeConstruccionInicial();

    public Region generarRegionAPartirDePosicion(Posicion posicion) {

        return new Region(posicion, this.TAMANIO_HORIZONTAL, this.TAMANIO_VERTICAL);

    }

    public void reparar() {
        this.sumarVida(this.VELOCIDAD_DE_REPARACION);
    }

}
