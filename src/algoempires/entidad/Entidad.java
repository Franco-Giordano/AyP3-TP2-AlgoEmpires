package algoempires.entidad;

import algoempires.jugador.Jugador;
import algoempires.tablero.Terreno;

public abstract class Entidad {

    protected Terreno terrenoDeJuego;
    protected int vida;

    public Entidad(Terreno terreno) {
        this.terrenoDeJuego = terreno;
        this.vida = getVidaInicial();
    }

    protected abstract int getVidaInicial();

    public abstract void actualizarEntreTurnos(Jugador jugador);

    //Metodo de testeo
    public boolean tieneEstaVida(int vidaRecibida){
        return this.vida == vidaRecibida;
    }

}
