package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;


public abstract class Unidad extends Entidad {

    private Posicion posicionQueOcupo;
    private boolean movioEsteTurno;

    public Unidad(Terreno terreno, Posicion posicion) throws CasilleroInvalidoException {
        super(terreno);
        this.posicionQueOcupo = posicion;
        this.terrenoDeJuego.ocupar(posicionQueOcupo, this);
        this.movioEsteTurno = false;
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {
        if (movioEsteTurno) {
            throw new UnidadYaMovioEnEsteTurnoException();
        }

        terrenoDeJuego.moverUnidad(posicionQueOcupo, direccion);
        this.posicionQueOcupo = posicionQueOcupo.generarMovimientoHacia(direccion);
        movioEsteTurno = true;
    }

    public boolean estaEnCasillero(Posicion posicion) {
        return posicionQueOcupo.equals(posicion);
    }

}
