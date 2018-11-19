package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.jugador.Jugador;

public class Castillo extends Edificio {

    private final int VIDA_INICIAL = 450;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo() {
        super();

        TAMANIO_HORIZONTAL = 4;
        TAMANIO_VERTICAL = 4;
        VELOCIDAD_DE_REPARACION = 15;
        RANGO_VISION = 3;
        COSTO = 0;
    }

    @Override
    protected int getTurnosDeConstruccionInicial() {
        return 0;
    }


    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio();
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {

    }
}
