package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;

public class Arquero extends Guerrero {

    private final int VIDA_INICIAL = 50;
    private final int COSTO = 10;

    public Arquero(Jugador jugador) {
        super(jugador);

        RANGO_VISION = 3;
        DANIO_A_UNIDADES = 15;
        DANIO_A_EDIFICIOS = 10;

    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }


    @Override
    public boolean esDelEquipo(Jugador jugador) {
        return jugador == jugadorPropietario;
    }


}
