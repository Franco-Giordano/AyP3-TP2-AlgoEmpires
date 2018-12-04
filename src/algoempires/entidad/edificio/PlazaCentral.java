package algoempires.entidad.edificio;

import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;

public class PlazaCentral extends Edificio {

    private final int VIDA_MAXIMA = 450;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 3;
    private final int COSTO = 100;


    public PlazaCentral(Jugador jugador) {
        super(jugador);

        TAMANIO_HORIZONTAL = 2;
        TAMANIO_VERTICAL = 2;
        VELOCIDAD_DE_REPARACION = 25;
        RANGO_VISION = 1;

    }

    public PlazaCentral() {
        super();
        TAMANIO_HORIZONTAL = 2;
        TAMANIO_VERTICAL = 2;
        RANGO_VISION = 1;
    }

    @Override
    protected int getTurnosDeConstruccionInicial() {
        return TURNOS_DE_CONSTRUCCION_INICIAL;
    }


    @Override
    protected int getVidaInicial() {
        return (VIDA_MAXIMA / getTurnosDeConstruccionInicial());
    }

    @Override
    public int getVidaMaxima() {
        return VIDA_MAXIMA;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }

    public Aldeano crearAldeano() {
        this.esFuncional();
        return new Aldeano(jugadorPropietario);
    }


    @Override
    public void actualizarEntreTurnos() {
    }

}

