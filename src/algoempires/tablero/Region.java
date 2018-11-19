package algoempires.tablero;

import algoempires.entidad.unidad.Unidad;

import java.util.ArrayList;

//TODO tiene sentido esta clase ahora? solamente está generando ArrayList<Posicion>
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

    public static ArrayList<Posicion> generarRegionCentradaEn(Posicion posicionCentral, Unidad unidadConRango) {

        //la posición en este caso es el casillero central.

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        int minRangoHorizontal = posicionCentral.getHorizontal() - unidadConRango.getRango();
        int maxRangoHorizontal = posicionCentral.getHorizontal() + unidadConRango.getRango();
        int minRangoVertical = posicionCentral.getVertical() - unidadConRango.getRango();
        int maxRangoVertical = posicionCentral.getVertical() + unidadConRango.getRango();

        for (int i = minRangoHorizontal; i <= maxRangoHorizontal; i++) {

            for (int j = minRangoVertical; j <= maxRangoVertical; j++) {

                if (i != posicionCentral.getHorizontal() && j != posicionCentral.getVertical()) {
                    Posicion posicionContenido = new Posicion(i, j);
                    posicionesContenidas.add(posicionContenido);
                }
            }

        }

        return posicionesContenidas;
    }


}
