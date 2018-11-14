package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;

public class Aldeano extends Utilero {

    final int VIDA = 50;
    final int COSTO= 25;
    private static Edificio construccionPendiente;

    public Aldeano(Terreno terreno, Casillero casillero) {

        super(terreno,casillero);
        this.construccionPendiente = null;

    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    protected int getCosto(){
        return COSTO;
    }
}
