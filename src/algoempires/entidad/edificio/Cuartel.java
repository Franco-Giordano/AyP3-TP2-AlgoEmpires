package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public class Cuartel extends Edificio {

    private final int TAMANIO_HORIZONTAL = 2;
    private final int TAMANIO_VERTICAL = 2;
    private final int VIDA_INICIAL = 250;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 3;
    private final int VELOCIDAD_DE_REPARACION = 50;

    public Cuartel(Terreno terreno, Posicion posicion) throws CasilleroInvalidoException {
        super(terreno, posicion);
        this.vida = getVidaInicial();
    }

    public void crearEspadachin(Posicion posicion) throws CasilleroInvalidoException {
        new Espadachin(terrenoDeJuego, posicion);
    }

    public void crearArquero(Posicion posicion) throws CasilleroInvalidoException {
        new Arquero(terrenoDeJuego, posicion);
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

