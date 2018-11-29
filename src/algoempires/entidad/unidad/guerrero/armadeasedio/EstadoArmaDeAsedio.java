package algoempires.entidad.unidad.guerrero.armadeasedio;

public abstract class EstadoArmaDeAsedio {


    public abstract EstadoArmaDeAsedio actualizarEntreTurnos();

    public abstract boolean sePuedeMover();

    public abstract boolean puedeAtacar();

    public abstract boolean estaMontada();
}
