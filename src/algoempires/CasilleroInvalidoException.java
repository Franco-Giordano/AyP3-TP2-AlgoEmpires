package algoempires;

public class CasilleroInvalidoException extends Exception {

    public CasilleroInvalidoException(Casillero casillero) {
        super(String.format("Se trato de ocupar coordenada ya ocupada o fuera de rango: (%d, %d)",
                casillero.getHorizontal(), casillero.getVertical()));
    }
}
