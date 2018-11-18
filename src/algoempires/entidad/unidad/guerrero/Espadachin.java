package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Entidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;

public class Espadachin extends Guerrero {

    private final int VIDA_INICIAL = 100;
    private final int RANGO_ATAQUE = 1;
    private final int DANIO_A_UNIDADES = 25;
    private final int DANIO_A_EDIFICIOS = 15;

    public Espadachin() throws CasilleroInvalidoException {

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
    public int getRango() {
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


    public void imprimirListaDeEntidades() {

        if (!this.atacables.isEmpty()) {
            for (Entidad each : this.atacables) {
                System.out.println(each);
            }
        }else {
            System.out.println("Esta unidad no ve a nadie.");
        }
    }
}
