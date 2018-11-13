package algoempires;

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
                                        posHorizontal < limiteSupDer.getHorizontal();

        return estaEnRangoHorizontal && estaEnRangoVertical;

    }

    public Region generarRegion() {
    }
}
