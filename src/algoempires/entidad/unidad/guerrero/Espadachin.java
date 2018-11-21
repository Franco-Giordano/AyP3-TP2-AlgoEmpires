package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;

public class Espadachin extends Guerrero {

    private final int VIDA_INICIAL = 100;
    private final int COSTO = 50;

    public Espadachin(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);

        RANGO_VISION = 1;
        DANIO_A_UNIDADES = 25;
        DANIO_A_EDIFICIOS = 15;

    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto(){
        return COSTO;
    }

    @Override
    public void actualizarEntreTurnos() {

    }

}
