package algoempires;

import java.util.HashMap;

public class Posicion {


    private Region region;
    private Parcela parcelaActual;
    private HashMap<String, Parcela> parcelasAdyacentes;
    private String[] direccionesPosibles = {"superiorIzquierda", "superior", "superiorDerecha",
                                            "izquierda",                     "derecha",
                                            "inferiorIzquierda", "inferior", "inferiorDerecha"};

    public Posicion(Region region) {
        this.centrarPosicionEn(region);
    }

    private void centrarPosicionEn(Region region) {
        this.parcelaActual = region.getParcelaCentral();
        this.parcelasAdyacentes = region.calcularMapaAdyacentes(direccionesPosibles);
    }


    public void desplazarHaciaArribaIzquierda() {
        //region.moverANuevoCentro(parcelasAdyacentes["superiorIzquierda"]);
    }

    public void desplazarHaciaArribaDerecha() {

    }

    public void desplazarHaciaArriba() {

    }

    public void desplazarHaciaIzquierda() {

    }

    public void desplazarHaciaDerecha() {

    }

    public void desplazarHaciaAbajoIzquierda() {

    }

    public void desplazarHaciaAbajoDerecha() {

    }

    public void desplazarHaciaAbajo() {

    }
}
