package algoempires.entidad;


import algoempires.Parcela;

public abstract class Entidad {

    private int vida;
    private int costo;
    private Parcela parcelaQueOcupo;


    public Entidad(int vidaRecibida, int costoRecibido) {
        this.vida = vidaRecibida;
        this.costo = costoRecibido;
        this.parcelaQueOcupo = null;

    }

    public Parcela getParcelaQueOcupo() {
        return this.parcelaQueOcupo;
    }

    public void setParcelaQueOcupo(Parcela nuevaParcelaOcupante) {
        this.parcelaQueOcupo = nuevaParcelaOcupante;
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
