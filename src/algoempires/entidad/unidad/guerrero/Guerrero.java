package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Atacante;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

public abstract class Guerrero extends Unidad implements Atacante {

    protected int DANIO_A_UNIDADES;
    protected int DANIO_A_EDIFICIOS;


    public Guerrero(Jugador jugador) {

        super(jugador);
    }

    public void atacar(Unidad unidad) {
        unidad.restarVida(DANIO_A_UNIDADES);
    }

    public void atacar(Edificio edificio) {
        edificio.restarVida(DANIO_A_EDIFICIOS);
    }

    public boolean puedeVerA(Terreno terreno, Posicion posicionVictima) {
        return terreno.puedeUnidadVerA(this, posicionVictima);
    }

}
