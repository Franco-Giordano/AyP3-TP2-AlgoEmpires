package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;

public class Arquero extends Guerrero {

    private final int VIDA_INICIAL = 50;
    private final int COSTO = 75;

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
    public void actualizarEntreTurnos() {
        super.actualizarEntreTurnos();

    }


    @Override
    public boolean esDelEquipo(Jugador jugador) {
        return jugador == jugadorPropietario;
    }


    public boolean tieneEstasCaracteristicas(int vida, int rango, int danioUnidades, int danioEdificios) {
        return ((this.VIDA_INICIAL == vida) && (this.RANGO_VISION == rango)
                && (this.DANIO_A_EDIFICIOS == danioEdificios) && (this.DANIO_A_UNIDADES == danioUnidades));

    }

}
