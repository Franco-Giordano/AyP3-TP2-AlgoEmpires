package algoempires.entidad;

import algoempires.jugador.Jugador;

public abstract class Entidad {

    protected int COSTO;
    protected int RANGO_VISION;
    protected int vida;

    public Entidad() {
        this.vida = getVidaInicial();
    }

    protected abstract int getVidaInicial();

    public boolean restarVida(int vidaARestar){
        vida-= vidaARestar;
        return seMurioAlRecibirAtaque();
    }

    private boolean seMurioAlRecibirAtaque() {
        return vida<=0;
    }

    public abstract void actualizarEntreTurnos(Jugador jugador);

    public void sumarVida(int vidaASumar) {
        this.vida += vidaASumar;
    }

    //Metodo de testeo
    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }
}
