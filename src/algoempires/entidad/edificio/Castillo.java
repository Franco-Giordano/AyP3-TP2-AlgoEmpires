package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.jugador.Jugador;

public class Castillo extends Edificio {

    private final int TAMANIO_HORIZONTAL = 4;
    private final int TAMANIO_VERTICAL = 4;
    private final int VIDA_INICIAL = 450;
    private final int VELOCIDAD_DE_REPARACION = 15;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo() {
        super();
        this.setVida(getVidaInicial());
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio();
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
        return 0;
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {

    }
}
