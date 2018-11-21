package algoempires.entidad.unidad;

import algoempires.entidad.Entidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;


public abstract class Unidad extends Entidad {

    private boolean movioEsteTurno;

    public Unidad(Jugador jugador) throws PosicionInvalidaException {
        super(jugador);
        jugadorPropietario.agregar(this);
        this.movioEsteTurno = false;
    }

    public void seMovio() {
        this.movioEsteTurno = true;
    }

    @Override
    public void restarVida(int vidaARestar) {

        vida -= vidaARestar;

        if (vida <= 0) {
            jugadorPropietario.informarDestruccion(this);
        }

    }


    public boolean sePuedeMover() {
        return !this.movioEsteTurno;
    }
}
