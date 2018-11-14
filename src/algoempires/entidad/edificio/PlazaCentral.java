package algoempires.entidad.edificio;

import algoempires.Parcela;

public class PlazaCentral extends Edificio {

    private static int vida = 450;
    private static int costo = 100;
    private static int turnosDeConstruccion = 3;

    public PlazaCentral() {
        super(vida, costo, null,turnosDeConstruccion);
    }

}
