package algoempires.tablero;

import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.utilero.Aldeano;

import java.util.ArrayList;

public class Region {

    private Posicion infIzquierdo;
    private int tamanioHorizontal;
    private int tamanioVertical;

    public Region(Posicion infIzquierdo, int tamanioHorizontal, int tamanioVertical) {

        this.infIzquierdo = infIzquierdo;
        this.tamanioVertical = tamanioVertical;
        this.tamanioHorizontal = tamanioHorizontal;

    }


    public ArrayList<Posicion> generarPosicionesContenidas() {

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

    public ArrayList<Posicion> generarRango(Unidad unidad, Posicion posicion) {

        //A diferencia del método de arriba, la posición en este caso, es el casillero central.

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        for (int i = posicion.getHorizontal() - unidad.getRango(); i <= posicion.getHorizontal() + unidad.getRango(); i ++){
            for (int j = posicion.getVertical() - unidad.getRango(); j <= posicion.getVertical() + unidad.getRango(); j++){
                if (i == posicion.getHorizontal() && j == posicion.getVertical()) {
                }
                else{
                    Posicion posicionContenido = new Posicion(i, j);
                    posicionesContenidas.add(posicionContenido);
                }
            }
        }

        return posicionesContenidas;
    }

}
