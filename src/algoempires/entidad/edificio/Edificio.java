package algoempires.entidad.edificio;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.Region;

public abstract class Edificio extends Entidad {

    protected int TAMANIO_HORIZONTAL;
    protected int TAMANIO_VERTICAL;
    protected int VIDA_INICIAL;
    protected int VELOCIDAD_DE_REPARACION;

    private int turnosDeConstruccion;

    public Edificio(Jugador jugador) throws PosicionInvalidaException {
        super(jugador);
        jugadorPropietario.agregar(this);
        this.turnosDeConstruccion = getTurnosDeConstruccionInicial();

    }

    protected abstract int getTurnosDeConstruccionInicial();

    public Region generarRegionAPartirDePosicion(Posicion posicionInfIzq) {

        return new Region(posicionInfIzq, this.TAMANIO_HORIZONTAL, this.TAMANIO_VERTICAL);

    }

    public void reparar() {
        this.sumarVida(this.VELOCIDAD_DE_REPARACION);
    }

    @Override
    public void restarVida(int vidaARestar) {

        vida -= vidaARestar;

        if (vida <= 0) {
            jugadorPropietario.informarDestruccion(this);
        }

    }

    public void recibirAtaqueDe(Atacante atacante) {
        atacante.atacar(this);
    }

}
