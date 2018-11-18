package algoempires.entidad.unidad.guerrero;

import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;

public class ArmaDeAsedio extends Guerrero {

    private final int VIDA = 150;
    private final int RANGO_ATAQUE = 5;
    private final int DANIO_A_EDIFICIOS = 75;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 1;


    private int turnosDeConstruccion;

    private boolean estaMontada;

    public ArmaDeAsedio() throws CasilleroInvalidoException {

        super();

        this.turnosDeConstruccion = TURNOS_DE_CONSTRUCCION_INICIAL;

        this.estaMontada = false;

    }

    public void montar() {
        estaMontada = true;
    }

    /*public void desmontar() {
        estaMontada = false;
    }*/

    @Override
    protected int getVidaInicial() {
        return VIDA;
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
        return 0;
    }

    @Override
    protected int getDanioAEdificios() {
        return DANIO_A_EDIFICIOS;
    }

    public boolean tieneEstasCaracteristicas(int vida, int rangoAtaque, int turnosDeConstruccion, int danioAEdficios, boolean estaMontada) {
        return ((this.getVidaInicial() == vida) && (this.getDanioAEdificios() == danioAEdficios)
                && (this.estaMontada == estaMontada) && (this.getRango() == rangoAtaque)
                && (this.turnosDeConstruccion == turnosDeConstruccion) && (this.getDanioAUnidades() == 0));
    }
}

