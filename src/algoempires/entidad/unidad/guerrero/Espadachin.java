package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;

public class
Espadachin extends Guerrero {

    private final int VIDA_INICIAL = 100;

    public Espadachin(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);

        RANGO_VISION = 1;
        DANIO_A_UNIDADES = 25;
        DANIO_A_EDIFICIOS = 15;
        COSTO = 50;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {

    }

    @Override
    public void atacar(Unidad unidad) {
        unidad.restarVida(DANIO_A_UNIDADES);
    }

    @Override
    public void atacar(Edificio edificio) {
        edificio.restarVida(DANIO_A_EDIFICIOS);
    }

}
