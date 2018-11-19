package algoempires.entidad;

import algoempires.jugador.Jugador;

public abstract class Entidad {

    private int vida;
    public Entidad() {
        this.vida = getVidaInicial();

    }

    public boolean restarVida(int vidaARestar){
        vida-= vidaARestar;
        return seMurioAlRecibirAtaque();
    }

    public boolean seMurioAlRecibirAtaque(){
        return vida<=0;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    protected abstract int getVidaInicial();

    public abstract void actualizarEntreTurnos(Jugador jugador);

    //Metodo de testeo
    public boolean tieneEstaVida(int vidaRecibida) {
        return this.vida == vidaRecibida;
    }

    public void sumarVida(int vidaASumar){
        this.vida+=vidaASumar;
    }
}
