package algoempires.entidad.edificio;

import algoempires.Parcela;
import algoempires.Region;

public class Cuartel extends Edificio {

    private static int vida = 250;
    private static int costo = 50;
    private static int turnosDeConstruccion = 3;
    private static Region tamanio = new Region(new Parcela[2][2]);

    public Cuartel(){
        super(vida,costo,null,turnosDeConstruccion,tamanio);
    }
}
