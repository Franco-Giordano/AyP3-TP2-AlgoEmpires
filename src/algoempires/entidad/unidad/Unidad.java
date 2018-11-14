package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;


public abstract class Unidad extends Entidad {

    private Casillero casilleroQueOcupo;
    private boolean movioEsteTurno;

    public Unidad(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno);
        this.casilleroQueOcupo = casillero;
        this.terrenoDeJuego.ocupar(casilleroQueOcupo, this);
        this.movioEsteTurno = false;
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {
        if (movioEsteTurno) {
            throw new UnidadYaMovioEnEsteTurnoException();
        }

        terrenoDeJuego.moverUnidad(casilleroQueOcupo, direccion);
        this.casilleroQueOcupo = casilleroQueOcupo.generarMovimientoHacia(direccion);
        movioEsteTurno = true;
    }

    public boolean estaEnCasillero(Casillero casillero) {
        return casilleroQueOcupo.equals(casillero);
    }

}
