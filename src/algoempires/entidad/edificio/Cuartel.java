package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;

public class Cuartel extends Edificio {

    private final int TAMANIO_HORIZONTAL = 2;
    private final int TAMANIO_VERTICAL = 2;
    private final int COSTO = 50;
    private final int VIDA = 250;
    private final int TURNOS_DE_CONSTRUCCION = 3;
    private final int VELOCIDAD_DE_REPARACION = 50;

    public Cuartel(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno, casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
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

    public int getVida() {
        return vida;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }
}

