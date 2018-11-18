package algoempires.entidad;

public class SoloEdificiosPuedenSerReparadosException extends RuntimeException {

    public SoloEdificiosPuedenSerReparadosException() {
        super(String.format("Se trato de reparar una unidad."));
    }
}
