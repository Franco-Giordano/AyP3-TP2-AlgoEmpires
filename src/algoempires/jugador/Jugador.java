package algoempires.jugador;

import algoempires.entidad.Entidad;
import algoempires.tablero.Terreno;

import java.util.ArrayList;

public class Jugador {

    private ArrayList<Entidad> entidadesPropias;
    private Terreno terrenoDeJuego;
    private Jugador jugadorContrincante;
    private Monedero monedero;

    public Jugador(Terreno terrenoDeJuego) {
        this.entidadesPropias = new ArrayList<>();
        this.terrenoDeJuego = terrenoDeJuego;
        this.monedero = new Monedero();
    }

    public void setContrincante(Jugador jugador) {
        jugadorContrincante = jugador;
    }

    public void jugarTurno() {


    }

    public void sumarOro(int oro) {
        monedero.sumarOro(oro);
    }


    //METODO DE TESTEO
    public int getOro() {
        return monedero.getOro();
    }

    public void asignarAlJugador(Entidad entidad) {
        entidadesPropias.add(entidad);
    }
}
