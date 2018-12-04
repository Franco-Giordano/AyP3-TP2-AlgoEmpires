package algoempires.entidad.unidad;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.excepciones.NoSeToleraFuegoAmigoException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;


public abstract class Unidad extends Entidad {

    protected Casillero casilleroQueLaContiene;
    private boolean movioEsteTurno;

    public Unidad(Jugador jugador) throws PosicionInvalidaException {
        super(jugador);
        jugadorPropietario.agregar(this);
        this.movioEsteTurno = false;
    }

    public void seMovioA(Casillero casilleroNuevo) {
        this.movioEsteTurno = true;
        this.casilleroQueLaContiene = casilleroNuevo;
    }

    @Override
    public void restarVida(int vidaARestar) {

        vida -= vidaARestar;

        if (this.seMurioAlRecibirAtaque()) {
            casilleroQueLaContiene.vaciar();
            jugadorPropietario.quitarDePoblacion(this);
        }

    }

    @Override
    protected int getVidaMaxima() {
        return getVidaInicial();
    }

    public void recibirAtaqueDe(Atacante atacante) {

        if (atacante.esDelEquipo(jugadorPropietario)) {
            throw new NoSeToleraFuegoAmigoException("Un atacante intento herir un aliado!");
        }

        atacante.atacar(this);
    }

    public void informarDeCasilleroOcupado(Casillero casillero) {
        this.casilleroQueLaContiene = casillero;
    }

    public boolean sePuedeMover() {
        return !this.movioEsteTurno;
    }

    public void actualizarEntreTurnos() {
        this.movioEsteTurno = false;
    }

    public Casillero getCasillero() {
        return casilleroQueLaContiene;
    }
}
