package algoempires.jugador;

public class SoloSePuedeRepararEdificiosException extends RuntimeException {

    public SoloSePuedeRepararEdificiosException(){
        super("Solo se pueden reparar Edificios.");
    }
}
