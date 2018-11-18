package algoempires.tablero;

public class DimensionesInvalidasError extends RuntimeException {


    public DimensionesInvalidasError(int horiz, int vert) {
        super(String.format("El terreno debe tener dimensiones positivas no nulas. Se ingreso: (%d, %d)",
                horiz, vert));
    }
}
