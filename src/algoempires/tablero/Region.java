package algoempires.tablero;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

import java.util.ArrayList;

public class Region {

    private Posicion infIzquierdo;
    private int tamanioHorizontal;
    private int tamanioVertical;
    private ArrayList<Casillero> casillerosQueContengo;

    public Region(Edificio edificio, ArrayList<Casillero> casillerosContenidos) {

        this.casillerosQueContengo = casillerosContenidos;

        for (Casillero casillero : casillerosContenidos){
            casillero.ocupar(edificio);
        }

    }

    public ArrayList<Posicion> generarPosicionesContenidas() {

        //Porque lo consideramos en un supuesto, la posición es la inferior izquierda.

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        for (int i = 0; i < tamanioHorizontal; i++) {
            for (int j = 0; j < tamanioVertical; j++) {
                Posicion posicionContenido = new Posicion(i + infIzquierdo.getHorizontal(),
                        j + infIzquierdo.getVertical());
                posicionesContenidas.add(posicionContenido);

            }
        }

        return posicionesContenidas;
    }

    protected int getVerticalSup() {
        return infIzquierdo.getVertical() + tamanioVertical - 1;
    }

    protected int getVerticalInf() {
        return infIzquierdo.getVertical();
    }

    protected int getHorizontalDer() {
        return infIzquierdo.getHorizontal() + tamanioHorizontal - 1;
    }

    protected int getHorizontalIzq() {
        return infIzquierdo.getHorizontal();
    }

    protected boolean contiene(Posicion posicion) {

        Posicion supDerecho = new Posicion(infIzquierdo.getHorizontal() + tamanioHorizontal - 1,
                infIzquierdo.getVertical() + tamanioVertical - 1);

        return posicion.pertenzcoAlRango(infIzquierdo, supDerecho);
    }


    public void vaciar() {
        for(Casillero casilleroActual : casillerosQueContengo){
            casilleroActual.vaciar();
        }
    }
}
