package algoempires.excepciones;

public class PosicionDeCreacionFueraDeRangoException extends RuntimeException {
    public PosicionDeCreacionFueraDeRangoException() {
        super("No se puede crear la unidad ahí (fuera de rango).");
    }
}
