package algoempires.entidad.unidad.guerrero.armadeasedio;

public class EstadoMontando extends EstadoArmaDeAsedio {
    @Override
    public EstadoArmaDeAsedio actualizarEntreTurnos() {
        return new EstadoDeAtaque();
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
    public boolean estaMontada(){ return true; }
}
