package algoempires.entidad.unidad.guerrero.armadeasedio;

public class ArmaDeAsedioNoPuedeAtacarUnidades extends RuntimeException {

    public ArmaDeAsedioNoPuedeAtacarUnidades() {
        super("El arma de asedio solo puede atacarA edificios.");
    }
}
