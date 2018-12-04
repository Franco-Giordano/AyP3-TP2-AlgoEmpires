package algoempires.entidad.unidad.guerrero.armadeasedio;

public class EstadoMovible extends EstadoArmaDeAsedio {
    @Override
    public EstadoArmaDeAsedio actualizarEntreTurnos() {
        return this;
    }

    @Override
    public boolean sePuedeMover() {
        return true;
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
