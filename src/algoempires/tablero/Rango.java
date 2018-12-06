package algoempires.tablero;

import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

import java.util.ArrayList;

public class Rango {

    public static ArrayList<Posicion> generarPosicionesVisiblesPor(Posicion posicionCentral, Unidad unidadConRango) {

        //la posición en este caso es el casillero central.

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        int minRangoHorizontal = posicionCentral.getHorizontal() - unidadConRango.getRango();
        int maxRangoHorizontal = posicionCentral.getHorizontal() + unidadConRango.getRango();
        int minRangoVertical = posicionCentral.getVertical() - unidadConRango.getRango();
        int maxRangoVertical = posicionCentral.getVertical() + unidadConRango.getRango();

        for (int i = minRangoHorizontal; i <= maxRangoHorizontal; i++) {

            for (int j = minRangoVertical; j <= maxRangoVertical; j++) {

                if (!(i == posicionCentral.getHorizontal() && j == posicionCentral.getVertical())) {
                    Posicion posicionContenido = new Posicion(i, j);
                    posicionesContenidas.add(posicionContenido);
                }
            }

        }

        return posicionesContenidas;
    }

    public static ArrayList<Posicion> generarPosicionesVisiblesPor(Region regionCentral, Edificio edificioConRango) {


        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        int minRangoHorizontal = regionCentral.getHorizontalIzq() - edificioConRango.getRango();
        int maxRangoHorizontal = regionCentral.getHorizontalDer() + edificioConRango.getRango();
        int minRangoVertical = regionCentral.getVerticalInf() - edificioConRango.getRango();
        int maxRangoVertical = regionCentral.getVerticalSup() + edificioConRango.getRango();

        for (int i = minRangoHorizontal; i <= maxRangoHorizontal; i++) {

            for (int j = minRangoVertical; j <= maxRangoVertical; j++) {

                Posicion posicion = new Posicion(i, j);

                if (!regionCentral.contiene(posicion)) {
                    posicionesContenidas.add(posicion);
                }
            }

        }

        return posicionesContenidas;
    }


    public static ArrayList<Posicion> generarPosicionConstruiblesPorCastillo(Region regionQueLoContiene, Castillo castillo) {

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        int minRangoHorizontal = regionQueLoContiene.getHorizontalIzq() - castillo.getRangoContruccion();
        int maxRangoHorizontal = regionQueLoContiene.getHorizontalDer() + castillo.getRangoContruccion();
        int minRangoVertical = regionQueLoContiene.getVerticalInf() - castillo.getRangoContruccion();
        int maxRangoVertical = regionQueLoContiene.getVerticalSup() + castillo.getRangoContruccion();

        for (int i = minRangoHorizontal; i <= maxRangoHorizontal; i++) {

            for (int j = minRangoVertical; j <= maxRangoVertical; j++) {

                Posicion posicion = new Posicion(i, j);

                if (!regionQueLoContiene.contiene(posicion)) {
                    posicionesContenidas.add(posicion);
                }
            }

        }

        return posicionesContenidas;

    }
}
