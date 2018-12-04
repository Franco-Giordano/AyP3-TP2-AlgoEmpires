package algoempires.entidad.unidad.utilero;

public abstract class EstadoAldeano {

    protected Aldeano aldeano;

    public EstadoAldeano(Aldeano aldeano) {
        this.aldeano = aldeano;
    }

    protected abstract EstadoAldeano actualizarEntreTurnos();

    public abstract boolean sePuedeMover();

    public abstract void chequearQueAldeanoEsteDisponible();
}
