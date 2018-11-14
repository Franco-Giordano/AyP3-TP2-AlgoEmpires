package algoempires.entidad.edificio;

import algoempires.Parcela;
import algoempires.Region;

public class PlazaCentral extends Edificio {

    private static int vida = 450;
    private static int costo = 100;
    private static int turnosDeConstruccion = 3;
    private static Region tamanio = new Region(new Parcela[2][2]);

    public PlazaCentral() {
        super(vida, costo, null,turnosDeConstruccion, tamanio);
    }

}
