package algoempires.entidad.unidad.guerrero.armadeasedio;

public class EstadoDeAtaque extends EstadoArmaDeAsedio {

    @Override
    public EstadoArmaDeAsedio actualizarEntreTurnos() {
        return this;
    }

    @Override
    public boolean sePuedeMover() {
        return false;
    }

    @Override
    public boolean puedeAtacar() {
        return true;
    }

    @Override
    public boolean estaMontada() {
        return true;
    }
}
