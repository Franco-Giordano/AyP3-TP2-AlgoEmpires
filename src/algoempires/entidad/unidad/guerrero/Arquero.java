package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;

public class Arquero extends Guerrero {

    private final int VIDA_INICIAL = 75;
    private final int RANGO_ATAQUE = 3;
    private final int DANIO_A_UNIDADES = 15;
    private final int DANIO_A_EDIFICIOS = 10;

    public Arquero() {
        super();
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }


    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }

    @Override
    protected int getRangoAtaque() {
        return RANGO_ATAQUE;
    }

    @Override
    protected int getDanioAUnidades() {
        return DANIO_A_UNIDADES;
    }

    @Override
    protected int getDanioAEdificios() {
        return DANIO_A_EDIFICIOS;
    }

    public boolean tieneEstasCaracteristicas(int vida, int rango, int danioUnidades, int danioEdificios) {
        return ((this.getVidaInicial() == vida) && (this.getRangoAtaque() == rango)
                && (this.getDanioAEdificios() == danioEdificios) && (this.getDanioAUnidades() == danioUnidades));
    }
}
