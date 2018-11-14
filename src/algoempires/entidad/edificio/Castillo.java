package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.maquina.ArmaDeAsedio;

public class Castillo extends Edificio {

    final int TAMANIO_HORIZONTAL = 4;
    final int TAMANIO_VERTICAL = 4;
    final int VIDA = 450;
    final int VELOCIDAD_DE_REPARACION = 15;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo(Terreno terreno, Casillero casillero) {
        super(terreno, casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    public void crearArmaDeAsedio(Casillero casillero) {
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
    protected int getCosto() {
        return 0;
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }
}
