package algoempires.excepciones;

public class EntidadFueraDeRangoException extends RuntimeException {
    public EntidadFueraDeRangoException() {
        super("Entidad está fuera de rango.");
    }
}
