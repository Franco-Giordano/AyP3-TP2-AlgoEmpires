package algoempires.excepciones;

public class PosicionFueraDeRangoException extends RuntimeException {
    public PosicionFueraDeRangoException() {
        super("La posicion seleccionada esta fuera de rango.");
    }
}
