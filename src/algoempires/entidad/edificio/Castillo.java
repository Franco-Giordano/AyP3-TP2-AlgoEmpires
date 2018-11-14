package algoempires.entidad.edificio;

import algoempires.Parcela;

public class Castillo extends Edificio{

    private static int vida = 1000;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo(){
        super(vida,0,null,0);
    }


}
