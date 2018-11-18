package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;

public class Cuartel extends Edificio {

    private final int TAMANIO_HORIZONTAL = 2;
    private final int TAMANIO_VERTICAL = 2;
    private final int VIDA_INICIAL = 250;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 3;
    private final int VELOCIDAD_DE_REPARACION = 50;

    public Cuartel() throws CasilleroInvalidoException {
        super();
        this.vida = getVidaInicial();
    }

    public Espadachin crearEspadachin() throws CasilleroInvalidoException {
        return new Espadachin();
    }

    public Arquero crearArquero() throws CasilleroInvalidoException {
        return new Arquero();
    }

    @Override
    protected int getTamanioHorizontal() {
        return TAMANIO_HORIZONTAL;
    }

    @Override
    protected int getTamanioVertical() {
        return TAMANIO_VERTICAL;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getTurnosDeContruccionIniciales() {
        return TURNOS_DE_CONSTRUCCION_INICIAL;
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }


    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }


    //METODO DE TESTEO
    public int getVidaActual() {
        return vida;
    }
}

