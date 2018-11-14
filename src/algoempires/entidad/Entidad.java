package algoempires.entidad;

import algoempires.jugador.Jugador;
import algoempires.tablero.Terreno;

public abstract class Entidad {

    protected Terreno terrenoDeJuego;
    protected int vida;

    public Entidad(Terreno terreno) {
        this.terrenoDeJuego = terreno;
    }

    protected abstract int getVidaInicial();

    public abstract void actualizarEntreTurnos(Jugador jugador);
}
