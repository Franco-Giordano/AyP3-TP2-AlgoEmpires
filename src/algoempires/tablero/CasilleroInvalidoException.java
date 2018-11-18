package algoempires.tablero;

public class CasilleroInvalidoException extends RuntimeException {

    public CasilleroInvalidoException() {
        super(String.format("Se trato de ocupar un casillero ya ocupado o invalido."));
    }
}
