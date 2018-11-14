package algoempires.entidad;


import algoempires.Parcela;

public abstract class Entidad {

    private int vida;
    private int costo;

    public Entidad(int vidaRecibida, int costoRecibido) {
        this.vida = vidaRecibida;
        this.costo = costoRecibido;

    }
    
    //----------------------------------------------------------------------------------------------------------------//
    //######################################### METODOS DE TESTEO ####################################################//
    //----------------------------------------------------------------------------------------------------------------//
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

}
