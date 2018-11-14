package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public abstract class Guerrero extends Unidad {


    //TODO Hacer metodos abstract para rango/danio/etc y exigir implementacion a hijos


    public Guerrero(Terreno terreno, Casillero casilleroRecibido) throws CasilleroInvalidoException {

        super(terreno, casilleroRecibido);
    }

    protected abstract int getRangoAtaque();

    protected abstract int getDanioAUnidades();

    protected abstract int getDanioAEdificios();



}
