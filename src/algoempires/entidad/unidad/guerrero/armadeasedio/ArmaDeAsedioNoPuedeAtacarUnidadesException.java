package algoempires.entidad.unidad.guerrero.armadeasedio;

public class ArmaDeAsedioNoPuedeAtacarUnidadesException extends RuntimeException {

    public ArmaDeAsedioNoPuedeAtacarUnidadesException() {
        super("El arma de asedio solo puede atacarA edificios.");
    }
}
