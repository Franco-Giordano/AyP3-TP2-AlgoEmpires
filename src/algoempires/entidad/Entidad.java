package algoempires.entidad;


import algoempires.Parcela;
import algoempires.Terreno;

public abstract class Entidad {

    protected Terreno terrenoDeJuego;
    protected int vida;

    public Entidad(Terreno terreno) {
        this.terrenoDeJuego = terreno;
    }

    protected abstract int getVidaInicial();
    protected abstract int getCosto();
}
