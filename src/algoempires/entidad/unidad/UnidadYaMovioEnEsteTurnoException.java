package algoempires.entidad.unidad;

public class UnidadYaMovioEnEsteTurnoException extends RuntimeException {

    public UnidadYaMovioEnEsteTurnoException() {
        super("Se intento desplazar una Unidad cuando ya fue movida este turno");
    }
}
