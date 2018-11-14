package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;
import algoempires.entidad.unidad.maquina.ArmaDeAsedio;

public class Castillo extends Edificio {

    private final int TAMANIO_HORIZONTAL = 4;
    private final int TAMANIO_VERTICAL = 4;
    private final int VIDA = 450;
    private final int VELOCIDAD_DE_REPARACION = 15;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno, casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    public void crearArmaDeAsedio(Casillero casillero) throws CasilleroInvalidoException {
        new ArmaDeAsedio(terrenoDeJuego, casillero);
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
