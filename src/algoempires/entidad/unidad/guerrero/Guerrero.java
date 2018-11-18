package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public abstract class Guerrero extends Unidad {


    public Guerrero(Terreno terreno, Posicion posicionRecibido) throws CasilleroInvalidoException {

        super(terreno, posicionRecibido);
    }

    protected abstract int getRangoAtaque();

    protected abstract int getDanioAUnidades();

    protected abstract int getDanioAEdificios();



}
