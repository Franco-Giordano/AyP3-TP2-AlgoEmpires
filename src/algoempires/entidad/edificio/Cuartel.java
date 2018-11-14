package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;

public class Cuartel extends Edificio {

    final int TAMANIO_HORIZONTAL = 2;
    final int TAMANIO_VERTICAL = 2;
    final int COSTO = 50;
    final int VIDA = 250;
    final int TURNOS_DE_CONSTRUCCION = 3;
    final int VELOCIDAD_DE_REPARACION = 50;

    public Cuartel(Terreno terreno, Casillero casillero) {
        super(terreno, casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    public void crearEspadachin(Casillero casillero) {
        new Espadachin(terrenoDeJuego, casillero);
    }

    public void crearArquero(Casillero casillero) {
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
    protected int getCosto() {
        return COSTO;
    }

    @Override
    protected int getVelocidadDeReparacion() {
        return VELOCIDAD_DE_REPARACION;
    }

    //metodo unicamente de testeo

    public int getVida() {
        return vida;
    }
}

