package algoempires.excepciones;

public class DimensionesInvalidasException extends RuntimeException {


    public DimensionesInvalidasException(int horiz, int vert) {
        super(String.format("El terreno debe tener dimensiones positivas no nulas. Se ingreso: (%d, %d)",
                horiz, vert));
    }

    public DimensionesInvalidasException(String msj) {
        super(msj);
    }
}
