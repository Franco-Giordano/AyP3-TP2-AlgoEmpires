package algoempires;

public class MovimientoInvalidoException extends Exception {

    public MovimientoInvalidoException(int posVertical, int posHorizontal) {
        super(String.format("Se desplazo a coordenada ocupada o fuera de rango: (%d, %d)", posVertical, posHorizontal));
    }
}
