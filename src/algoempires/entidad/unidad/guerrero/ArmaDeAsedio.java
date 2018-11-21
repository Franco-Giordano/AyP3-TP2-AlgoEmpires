package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;


public class ArmaDeAsedio extends Guerrero {

    private final int VIDA_INICIAL = 50;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 1;
    private final int COSTO = 200;

    private int turnosDeConstruccion;

    private boolean estaMontada;

    public ArmaDeAsedio(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);

        this.turnosDeConstruccion = TURNOS_DE_CONSTRUCCION_INICIAL;

        this.estaMontada = false;

        RANGO_VISION = 5;
        DANIO_A_EDIFICIOS = 75;


    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }

    public void montar() {
        estaMontada = true;
    }

    /*public void desmontar() {
        estaMontada = false;
    }*/

    @Override
    public void atacar(Unidad unidad) throws ArmaDeAsedioNoPuedeAtacarUnidades {
        throw new ArmaDeAsedioNoPuedeAtacarUnidades();
    }

    @Override
    public void actualizarEntreTurnos() {
    }

    public boolean tieneEstasCaracteristicas(int vida, int rangoAtaque, int turnosDeConstruccion, int danioAEdficios, boolean estaMontada) {
        return ((this.VIDA_INICIAL == vida) && (this.DANIO_A_EDIFICIOS == danioAEdficios)
                && (this.estaMontada == estaMontada) && (this.RANGO_VISION == rangoAtaque)
                && (this.turnosDeConstruccion == turnosDeConstruccion));
    }

    @Override
    public boolean sePuedeMover() {
        return !this.estaMontada && super.sePuedeMover();
    }
}

