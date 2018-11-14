package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Utilero extends Unidad {

    public Utilero(int vidaRecibida, int costoRecibido, Terreno terreno, Casillero casillero) {
        super(vidaRecibida, costoRecibido, terreno,casillero);
    }
}
