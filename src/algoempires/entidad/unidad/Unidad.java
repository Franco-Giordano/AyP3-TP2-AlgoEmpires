package algoempires.entidad.unidad;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;
import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;


public abstract class Unidad extends Entidad {

    private Casillero casilleroQueOcupo;

    public Unidad(int vidaRecibida, int costoRecibido,  Terreno terreno, Casillero casillero) {
        super(vidaRecibida, costoRecibido, terreno);
        this.casilleroQueOcupo = casillero;
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException {
        terrenoDeJuego.moverUnidad(casilleroQueOcupo, direccion);
    }

    public boolean estaEnCasillero(Casillero casillero) {
        return (this.casilleroQueOcupo == casillero);
    }

}
