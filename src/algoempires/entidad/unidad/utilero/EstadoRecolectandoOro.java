package algoempires.entidad.unidad.utilero;

import algoempires.jugador.Jugador;

public class EstadoRecolectandoOro extends Estado {

    public EstadoRecolectandoOro(Aldeano aldeano) {
        super(aldeano);
    }

    @Override
    protected Estado actualizarEntreTurnos() {
        aldeano.generarOro();

        return this;
    }
}
