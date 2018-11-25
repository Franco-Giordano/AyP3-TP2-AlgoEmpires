package algoempires.excepciones;

public class SoloUnidadesSePuedenDesplazarException extends RuntimeException {

    public SoloUnidadesSePuedenDesplazarException() {
        super("Se trato de desplazar un edificio.");
    }
}
