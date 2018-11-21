package algoempires.entidad.unidad;

public class UnidadNoPuedeMoverseException extends RuntimeException {

    public UnidadNoPuedeMoverseException() {
        super("Se intento desplazar una Unidad que no puede moverse actualmente");
    }
}
