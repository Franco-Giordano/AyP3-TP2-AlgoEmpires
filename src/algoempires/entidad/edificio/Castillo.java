package algoempires.entidad.edificio;

import algoempires.Parcela;
import algoempires.Region;

public class Castillo extends Edificio{

    private static int vida = 1000;
    private static Region tamanio = new Region(new Parcela[4][4]);

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo(){
        super(vida,0,0,tamanio);
    }


}
