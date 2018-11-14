package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Utilero extends Unidad {

    public Utilero(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno,casillero);
    }
}
