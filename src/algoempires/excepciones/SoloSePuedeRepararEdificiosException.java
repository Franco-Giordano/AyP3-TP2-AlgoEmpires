package algoempires.excepciones;

public class SoloSePuedeRepararEdificiosException extends RuntimeException {

    public SoloSePuedeRepararEdificiosException() {
        super("Solo se pueden reparar Edificios.");
    }
}
