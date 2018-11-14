package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public class Cuartel extends Edificio {

    private final int TAMANIO_HORIZONTAL = 2;
    private final int TAMANIO_VERTICAL = 2;
    private final int VIDA_INICIAL = 250;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 3;
    private final int VELOCIDAD_DE_REPARACION = 50;

    public Cuartel(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno, casillero);
        this.vida = getVidaInicial();
    }

    public void crearEspadachin(Casillero casillero) throws CasilleroInvalidoException {
        new Espadachin(terrenoDeJuego, casillero);
    }

    public void crearArquero(Casillero casillero) throws CasilleroInvalidoException {
        new Arquero(terrenoDeJuego, casillero);
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

