package algoempires.entidad.unidad;

public class UnidadYaMovioEnEsteTurnoException extends Exception {

    public UnidadYaMovioEnEsteTurnoException() {
        super("Se intento desplazar una Unidad cuando ya fue movida este turno");
    }
}
