package algoempires.entidad.edificio;

import algoempires.Parcela;

public class Cuartel extends Edificio {

    private static int vida = 250;
    private static int costo = 50;
    private static int turnosDeConstruccion = 3;

    public Cuartel(){
        super(vida,costo,null,turnosDeConstruccion);
    }
}
