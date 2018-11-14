package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public class Espadachin extends Guerrero {

    private final int VIDA_INICIAL = 100;
    private final int RANGO_ATAQUE = 1;
    private final int DANIO_A_UNIDADES = 25;
    private final int DANIO_A_EDIFICIOS = 15;

    public Espadachin(Terreno terreno, Casillero casilleroRecibido) throws CasilleroInvalidoException {

        super(terreno, casilleroRecibido);

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

}
