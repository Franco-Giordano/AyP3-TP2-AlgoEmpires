package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;
import algoempires.entidad.unidad.utilero.Aldeano;

public class PlazaCentral extends Edificio {

    private final int TAMANIO_HORIZONTAL = 2;
    private final int TAMANIO_VERTICAL = 2;
    private final int COSTO = 100;
    private final int VIDA = 450;
    private final int TURNOS_DE_CONSTRUCCION = 3;
    private final int VELOCIDAD_DE_REPARACION = 25;

    public PlazaCentral(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno, casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    public void crearAldeano(Casillero casillero) throws CasilleroInvalidoException {
        new Aldeano(terrenoDeJuego, casillero);
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
        return VIDA;
    }

    @Override
    protected int getTurnosDeContruccionIniciales() {
        return TURNOS_DE_CONSTRUCCION;
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }

}

