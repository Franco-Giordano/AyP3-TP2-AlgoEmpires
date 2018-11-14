package algoempires.tablero;

import java.util.ArrayList;

public class Region {

    private Casillero infIzquierdo;
    private int tamanioHorizontal;
    private int tamanioVertical;

    public Region(Casillero infIzquierdo, int tamanioHorizontal, int tamanioVertical) {

        this.infIzquierdo = infIzquierdo;
        this.tamanioVertical = tamanioVertical;
        this.tamanioHorizontal = tamanioHorizontal;

    }


    public ArrayList<Casillero> generarCasillerosContenidos() {

        ArrayList<Casillero> casillerosContenidos = new ArrayList<>();

        for (int i = 0; i < tamanioHorizontal; i++) {
            for (int j = 0; j < tamanioVertical; j++) {
                Casillero casilleroContenido = new Casillero(i + infIzquierdo.getHorizontal(),
                        j + infIzquierdo.getVertical());
                casillerosContenidos.add(casilleroContenido);
            }
        }

        return casillerosContenidos;
    }

}
