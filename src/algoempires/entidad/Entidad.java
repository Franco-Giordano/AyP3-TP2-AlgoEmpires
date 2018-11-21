package algoempires.entidad;

import algoempires.jugador.Jugador;
import algoempires.jugador.Monedero;

public abstract class Entidad {

    protected int COSTO;
    protected int RANGO_VISION;
    protected int vida;
    protected Jugador jugadorPropietario;

    public Entidad(Jugador propietarioDeEntidad) {
        this.vida = getVidaInicial();
        this.jugadorPropietario = propietarioDeEntidad;
        this.jugadorPropietario.cobrar(this.getCosto());
    }

    protected abstract int getVidaInicial();

    protected abstract int getCosto();

    public abstract void actualizarEntreTurnos();

    public void sumarVida(int vidaASumar) {
        this.vida += vidaASumar;
    }

    public abstract void restarVida(int vidaARestar);

    public void cobrar(Monedero monedero) {
        monedero.restarOro(COSTO);
    }

    public int getRango() {
        return RANGO_VISION;
    }
    //Metodo de testeo

    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }

}
