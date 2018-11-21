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
    }

    protected abstract int getVidaInicial();

    public void restarVida(int vidaARestar){

        vida-= vidaARestar;

        if (vida <= 0){
            jugadorPropietario.informarDestruccion(this);
        }

    }

    public abstract void actualizarEntreTurnos(Jugador jugador);

    public void sumarVida(int vidaASumar) {
        this.vida += vidaASumar;
    }

    public int getRango() {
        return RANGO_VISION;
    }

    //Metodo de testeo
    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }


    public void cobrar(Monedero monedero) {
        monedero.restarOro(COSTO);
    }
}
