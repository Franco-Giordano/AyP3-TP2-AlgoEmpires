package algoempires.jugador;

public class Monedero {

    private int cantidadOro;

    public Monedero() {
        this.cantidadOro = 0;
    }

    public void sumarOro(int oroASumar) {

        if (oroASumar > 0) {
            this.cantidadOro += oroASumar;
        }

    }

    public void restarOro(int oroASumar) {

        if (puedoDebitarElValor(oroASumar) && oroASumar > 0) {
            cantidadOro -= oroASumar;
        }
    }

    private boolean puedoDebitarElValor(int oroASumar) {
        return cantidadOro - oroASumar >= 0;
    }


    //METODO DE TESTEO
    public int getOro() {
        return cantidadOro;
    }
}
