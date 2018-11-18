package algoempires.tablero;

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

}
