package algoempires.tablero;

public class SoloUnidadesSePuedenDesplazarException extends RuntimeException {

    public SoloUnidadesSePuedenDesplazarException() {
        super(String.format("Se trato de desplazar un edificio."));
    }
}
