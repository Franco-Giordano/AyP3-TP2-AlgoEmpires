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

    public Entidad(){
        this.vida = getVidaInicial();
    }

    protected abstract int getVidaInicial();

    protected abstract int getCosto();

    public abstract void actualizarEntreTurnos();

    public abstract void restarVida(int vidaARestar);

    public boolean seMurioAlRecibirAtaque(){
        return vida <= 0;
    }

    public int getRango() {
        return RANGO_VISION;
    }
    //Metodo de testeo

    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }

    public abstract void recibirAtaqueDe(Atacante atacante);

    public int getVida() {
        return vida;
    }

    public boolean esDelEquipo(Atacante atacante) {
        return atacante.esDelEquipo(jugadorPropietario);
    }

    public String getNombreJugadorPropietario() {
        return jugadorPropietario.getNombre();
    }
}
