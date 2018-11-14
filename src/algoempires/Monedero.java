package algoempires;

public class Monedero {

    private int cantidadOro;

    public Monedero() {
        this.cantidadOro = 0;
    }

    public void sumarOro(int oroASumar) {
        this.cantidadOro += oroASumar;
    }

    public void restarDinero(int oroASumar) {
        if (puedoDebitarElValor(oroASumar)) {
            cantidadOro -= oroASumar;
        }
    }

    public boolean puedoDebitarElValor(int oroASumar) {
        return cantidadOro - oroASumar >= 0;
    }


    //METODO DE TESTEO
    public int getOro() {
        return cantidadOro;
    }
}
