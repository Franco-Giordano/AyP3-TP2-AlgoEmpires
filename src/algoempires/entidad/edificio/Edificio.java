package algoempires.entidad.edificio;

import algoempires.entidad.Entidad;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;

public abstract class Edificio extends Entidad {

    private int turnosDeConstruccion;

    public Edificio() throws CasilleroInvalidoException {
        super();

        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    public Region generarRegionAPartirDePosicion(Posicion posicion) {

        return new Region(posicion, this.getTamanioHorizontal(), this.getTamanioVertical());

    }

    public void reparar() {
        this.sumarVida(getVelocidadDeReparacion());
    }
    
    protected abstract int getTamanioHorizontal();

    protected abstract int getTamanioVertical();

    protected abstract int getTurnosDeContruccionIniciales();

    protected abstract int getVelocidadDeReparacion();

}
