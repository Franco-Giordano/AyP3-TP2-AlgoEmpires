package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;

public class Aldeano extends Utilero {

    private static int vidaDeAldeano = 50;
    private static int costoDeAldeano = 25;
    private static Edificio construccionPendiente;

    public Aldeano(Terreno terreno, Casillero casillero) {

        super(vidaDeAldeano, costoDeAldeano, terreno,casillero);
        this.construccionPendiente = null;

    }

}
