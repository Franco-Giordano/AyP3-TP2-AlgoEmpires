package algoempires.tablero;

import algoempires.tablero.direccion.Direccion;

public class Posicion {

    private int posHorizontal;
    private int posVertical;

    public Posicion(int posHorizontal, int posVertical) {

        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }


    public int getHorizontal() {
        return posHorizontal;
    }


    public int getVertical() {
        return posVertical;
    }

    public boolean pertenzcoAlRango(Posicion limiteInfIzq, Posicion limiteSupDer) {

        boolean estaEnRangoVertical = limiteInfIzq.getVertical() <= posVertical &&
                posVertical <= limiteSupDer.getVertical();
        boolean estaEnRangoHorizontal = limiteInfIzq.getHorizontal() <= posHorizontal &&
                posHorizontal <= limiteSupDer.getHorizontal();

        return estaEnRangoHorizontal && estaEnRangoVertical;

    }


    public Posicion generarMovimientoHacia(Direccion direccionRecibida) {

        return new Posicion(posHorizontal + direccionRecibida.getHorizontal(),
                posVertical + direccionRecibida.getVertical());

    }


    @Override
    public boolean equals(Object otro) {
        boolean result = false;
        if (otro instanceof Posicion) {
            Posicion that = (Posicion) otro;
            result = (this.posHorizontal == that.getHorizontal() && this.posVertical == that.getVertical());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (41 * (41 + posHorizontal) + posVertical);
    }


}
