package algoempires.entidad.unidad.guerrero.armadeasedio;

public class EstadoDesmontando extends EstadoArmaDeAsedio {

    @Override
    public EstadoArmaDeAsedio actualizarEntreTurnos() {
        return new EstadoMovible();
    }

    @Override
    public boolean sePuedeMover() {
        return false;
    }

    @Override
    public boolean puedeAtacar() {
        return false;
    }

    @Override
    public boolean estaMontada() {
        return false;
    }
}
