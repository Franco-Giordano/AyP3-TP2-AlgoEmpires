package algoempires.entidad.edificio;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.entidad.NoSeToleraFuegoAmigoException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.Region;

public abstract class Edificio extends Entidad {

    protected int TAMANIO_HORIZONTAL;
    protected int TAMANIO_VERTICAL;
    protected int VELOCIDAD_DE_REPARACION;

    private boolean estaEnReparacion;
    private int turnosDeConstruccion;

    public Edificio(Jugador jugador) throws PosicionInvalidaException {
        super(jugador);
        jugadorPropietario.agregar(this);
        this.turnosDeConstruccion = getTurnosDeConstruccionInicial();
        this.estaEnReparacion = true;
    }

    protected abstract int getVidaMaxima();

    protected abstract int getTurnosDeConstruccionInicial();

    public Region generarRegionAPartirDePosicion(Posicion posicionInfIzq) {

        return new Region(posicionInfIzq, this.TAMANIO_HORIZONTAL, this.TAMANIO_VERTICAL);

    }

    private void sumarVida(int vidaASumar) {
        this.vida += vidaASumar;
    }

    public void reparar() {

        this.sumarVida(this.VELOCIDAD_DE_REPARACION);

        if (this.tieneVidaLlena()) {
            this.vida = getVidaMaxima();
            this.estaEnReparacion = false;
        }
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

    public boolean tieneVidaLlena() {
        return this.vida >= getVidaMaxima();
    }

    public void continuarConstruccion() {
        this.turnosDeConstruccion--;
        this.sumarVida(getVidaInicial());
        if (this.tieneVidaLlena()) {
            this.vida = getVidaMaxima();
            this.estaEnReparacion = false;
        }
    }

    public boolean terminoConstruccion() {
        return turnosDeConstruccion == 0;
    }

    public boolean estaEnReparacion() {
        return estaEnReparacion;
    }
}
