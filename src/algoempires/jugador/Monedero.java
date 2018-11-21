package algoempires.jugador;

public class Monedero {

    private int cantidadOro;

    public Monedero() {
        this.cantidadOro = 100;
    }

    public void sumarOro(int oroASumar) {

        if (oroASumar > 0) {
            this.cantidadOro += oroASumar;
        }

    }

    public void restarOro(int oroARestar) {

        if (!puedoDebitarElValor(oroARestar) || oroARestar < 0) {
            throw new OroInsuficienteException("Se intento crear una unidad pero no se tenía el oro suficiente.");
        }

        cantidadOro -= oroARestar;
    }

    private boolean puedoDebitarElValor(int oroASumar) {
        return cantidadOro - oroASumar >= 0;
    }


    //METODO DE TESTEO
    public int getOro() {
        return cantidadOro;
    }
}
