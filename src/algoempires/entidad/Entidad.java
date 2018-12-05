package algoempires.entidad;

import algoempires.jugador.Jugador;

public abstract class Entidad {

    protected int RANGO_VISION;
    protected int vida;
    protected Jugador jugadorPropietario;

    public Entidad(Jugador propietarioDeEntidad) {
        this.vida = getVidaInicial();
        this.jugadorPropietario = propietarioDeEntidad;
        this.jugadorPropietario.cobrar(this.getCosto());
    }

    public Entidad() {
        this.vida = getVidaInicial();
    }

    public int getVida() {
        return vida;
    }

    protected abstract int getVidaInicial();

    public abstract int getVidaMaxima();

    protected abstract int getCosto();

    public abstract void actualizarEntreTurnos();

    public abstract void restarVida(int vidaARestar);

    public boolean seMurioAlRecibirAtaque() {
        return vida <= 0;
    }

    public int getRango() {
        return RANGO_VISION;
    }

    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }

    public abstract void recibirAtaqueDe(Atacante atacante);

    public boolean esDelEquipo(Atacante atacante) {
        return atacante.esDelEquipo(jugadorPropietario);
    }

    public boolean esDelEquipo(Jugador jugador) {
        return jugador == this.jugadorPropietario;
    }

    public String getNombreJugadorPropietario() {
        return jugadorPropietario.getNombre();
    }

    public double getPorcentajeDeVida() {
        return ((double) getVida() / getVidaMaxima());
    }


}
