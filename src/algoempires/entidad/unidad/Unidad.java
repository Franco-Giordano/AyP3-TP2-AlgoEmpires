package algoempires.entidad.unidad;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.excepciones.NoSeToleraFuegoAmigoException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;


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

    public void recibirAtaqueDe(Atacante atacante) {

        if (atacante.esDelEquipo(jugadorPropietario)) {
            throw new NoSeToleraFuegoAmigoException("Un atacante intento herir un aliado!");
        }

        atacante.atacar(this);
    }


    public boolean sePuedeMover() {
        return !this.movioEsteTurno;
    }

    public void actualizarEntreTurnos() {
        this.movioEsteTurno = false;
    }
}
