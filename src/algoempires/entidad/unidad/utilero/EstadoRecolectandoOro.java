package algoempires.entidad.unidad.utilero;

public class EstadoRecolectandoOro extends EstadoAldeano {

    public EstadoRecolectandoOro(Aldeano aldeano) {
        super(aldeano);
    }

    @Override
    protected EstadoAldeano actualizarEntreTurnos() {
        aldeano.generarOro();

        return this;
    }

    @Override
    public boolean sePuedeMover() {
        return true;
    }

    @Override
    public void chequearQueAldeanoEsteDisponible( ) {
    }
}
