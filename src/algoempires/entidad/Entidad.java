package algoempires.entidad;


import algoempires.Parcela;
import algoempires.Terreno;

public abstract class Entidad {

    private int vida;
    private int costo;
    protected Terreno terrenoDeJuego;

    public Entidad(int vidaRecibida, int costoRecibido, Terreno terreno) {
        this.vida = vidaRecibida;
        this.costo = costoRecibido;
        this.terrenoDeJuego = terreno;

    }
    
    //----------------------------------------------------------------------------------------------------------------//
    //######################################### METODOS DE TESTEO ####################################################//
    //----------------------------------------------------------------------------------------------------------------//
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

}
