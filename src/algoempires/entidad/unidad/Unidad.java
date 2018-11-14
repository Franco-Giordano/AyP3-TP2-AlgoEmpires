package algoempires.entidad.unidad;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;
import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;


public abstract class Unidad extends Entidad {

    private Casillero casilleroQueOcupo;

    public Unidad(Terreno terreno, Casillero casillero) {
        super(terreno);
        this.casilleroQueOcupo = casillero;
        this.terrenoDeJuego.ocupar(casilleroQueOcupo, this);
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException {
        terrenoDeJuego.moverUnidad(casilleroQueOcupo, direccion);
        this.casilleroQueOcupo = casilleroQueOcupo.generarMovimientoHacia(direccion);

    }

    public boolean estaEnCasillero(Casillero casillero) {
        return casilleroQueOcupo.equals(casillero);
    }

}
