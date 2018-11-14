package algoempires;

import algoempires.direccion.Direccion;

public class Casillero {

    private int posHorizontal;
    private int posVertical;

    public Casillero(int posHorizontal, int posVertical) {

        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }


    public int getHorizontal() {
        return posHorizontal;
    }


    public int getVertical() {
        return posVertical;
    }

    public boolean pertenzcoAlRango(Casillero limiteInfIzq, Casillero limiteSupDer) {

        boolean estaEnRangoVertical = limiteInfIzq.getVertical() <= posVertical &&
                posVertical <= limiteSupDer.getVertical();
        boolean estaEnRangoHorizontal = limiteInfIzq.getHorizontal() <= posHorizontal &&
                posHorizontal <= limiteSupDer.getHorizontal();

        return estaEnRangoHorizontal && estaEnRangoVertical;

    }


    public Casillero generarMovimientoHacia(Direccion direccionRecibida) {

        return new Casillero(posHorizontal + direccionRecibida.getHorizontal(),
                posVertical + direccionRecibida.getVertical());

    }


    @Override
    public boolean equals(Object otro) {
        boolean result = false;
        if (otro instanceof Casillero) {
            Casillero that = (Casillero) otro;
            result = (this.posHorizontal == that.getHorizontal() && this.posVertical == that.getVertical());
        }
        return result;
    }

    @Override
    public int hashCode() {
        return (41 * (41 + posHorizontal) + posVertical);
    }


}
