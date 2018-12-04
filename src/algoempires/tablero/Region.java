package algoempires.tablero;

import algoempires.entidad.edificio.Edificio;
import algoempires.excepciones.PosicionInvalidaException;

import java.util.ArrayList;

public class Region {


    private ArrayList<Casillero> casillerosQueContengo;

    public Region(Edificio edificio, ArrayList<Casillero> casillerosContenidos) {
        levantarExcepcionSiAlgunaOcupada(casillerosContenidos);

        this.casillerosQueContengo = casillerosContenidos;

        for (Casillero casillero : casillerosContenidos) {
            casillero.ocupar(edificio);
        }

    }

    private void levantarExcepcionSiAlgunaOcupada(ArrayList<Casillero> casillerosTentativos) {

        for (Casillero casillero : casillerosTentativos) {
            if (casillero.estaOcupada()) {
                throw new PosicionInvalidaException("Se intento construir en una region ya ocupada");
            }
        }
    }

    public Posicion getPosicionSuperiorDerecha() {

        Posicion maximoBuscado = new Posicion(0, 0);
        for (Casillero casilleroActual : casillerosQueContengo) {
            if (casilleroActual.tieneCoordenadasMayoresA(maximoBuscado)) {
                maximoBuscado = casilleroActual.getPosicion();
            }
        }

        return maximoBuscado;
    }

    public Posicion getPosicionInferiorIzquierda() {

        Posicion minimoBuscado = this.getPosicionSuperiorDerecha();

        for (Casillero casilleroActual : casillerosQueContengo) {
            if (casilleroActual.tieneCoordenadasMenoresA(minimoBuscado)) {
                minimoBuscado = casilleroActual.getPosicion();
            }
        }
        return minimoBuscado;
    }

    public int getTamanioHorizontal() {
        Posicion infIzquierdo = this.getPosicionInferiorIzquierda();
        Posicion supDerecho = this.getPosicionSuperiorDerecha();

        return supDerecho.getHorizontal() - infIzquierdo.getHorizontal();
    }

    public int getTamanioVertical() {
        Posicion infIzquierdo = this.getPosicionInferiorIzquierda();
        Posicion supDerecho = this.getPosicionSuperiorDerecha();

        return supDerecho.getVertical() - infIzquierdo.getVertical();
    }


    public boolean contiene(Posicion posicion) {

        Posicion infIzquierdo = this.getPosicionInferiorIzquierda();
        Posicion supDerecho = this.getPosicionSuperiorDerecha();

        int tamanioHorizontal = this.getTamanioHorizontal();
        int tamanioVertical = this.getTamanioVertical();

        supDerecho = new Posicion(infIzquierdo.getHorizontal() + tamanioHorizontal - 1,
                infIzquierdo.getVertical() + tamanioVertical - 1);

        return posicion.pertenezcoAlRango(infIzquierdo, supDerecho);
    }


    public void vaciar() {
        for (Casillero casilleroActual : casillerosQueContengo) {
            casilleroActual.vaciar();
        }
    }

    public int getHorizontalIzq() {
        return this.getPosicionInferiorIzquierda().getHorizontal();
    }

    public int getHorizontalDer() {
        return this.getPosicionInferiorIzquierda().getHorizontal() + this.getTamanioHorizontal();
    }


    public int getVerticalInf() {
        return this.getPosicionInferiorIzquierda().getVertical();
    }


    public int getVerticalSup() {
        return this.getPosicionInferiorIzquierda().getVertical() + this.getTamanioVertical();
    }

    public Casillero getUnCasillero() {
        return casillerosQueContengo.get(1);
    }
}
