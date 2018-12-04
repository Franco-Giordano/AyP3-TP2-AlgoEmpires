package algoempires.tablero;

import algoempires.tablero.direccion.Direccion;

public class Posicion {

    private int posHorizontal;
    private int posVertical;

    public Posicion(int posHorizontal, int posVertical) {

        this.posHorizontal = posHorizontal;
        this.posVertical = posVertical;
    }

    public Posicion(int posHorizontal, int posVertical, Posicion desplazamiento) {

        this.posHorizontal = posHorizontal + desplazamiento.getHorizontal();
        this.posVertical = posVertical + desplazamiento.getVertical();
    }


    public int getHorizontal() {
        return posHorizontal;
    }


    public int getVertical() {
        return posVertical;
    }


    public Posicion generarMovimientoHacia(Direccion direccionRecibida) {

        return new Posicion(posHorizontal + direccionRecibida.getHorizontal(),
                posVertical + direccionRecibida.getVertical());

    }

    public boolean pertenezcoAlRango(Posicion limiteInfIzq, Posicion limiteSupDer) {

        boolean estaEnRangoVertical = limiteInfIzq.getVertical() <= posVertical &&
                posVertical <= limiteSupDer.getVertical();
        boolean estaEnRangoHorizontal = limiteInfIzq.getHorizontal() <= posHorizontal &&
                posHorizontal <= limiteSupDer.getHorizontal();

        return estaEnRangoHorizontal && estaEnRangoVertical;

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


    public double getModulo() {
        return Math.sqrt(Math.pow(posHorizontal, 2) + Math.pow(posVertical, 2));
    }

    public boolean esMayorQue(Posicion maximoBuscado) {
        return (this.posHorizontal > maximoBuscado.getHorizontal() && this.posVertical > maximoBuscado.getVertical());
    }

    public boolean esMenorQue(Posicion minimoBuscado) {
        return (this.posHorizontal < minimoBuscado.getHorizontal() && this.posVertical < minimoBuscado.getVertical());
    }
}
