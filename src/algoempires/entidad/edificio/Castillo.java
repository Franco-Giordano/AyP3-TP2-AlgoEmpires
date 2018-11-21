package algoempires.entidad.edificio;

import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.jugador.Jugador;

public class Castillo extends Edificio {

    private final int VIDA_INICIAL = 450;
    private final int COSTO = 0;

    /*TODO revisar esto porque Castillo no corresponde a ser un edificio, ni una entidad. (0 turnos, 0 costo)*/
    public Castillo(Jugador jugador) {
        super(jugador);

        TAMANIO_HORIZONTAL = 4;
        TAMANIO_VERTICAL = 4;
        VELOCIDAD_DE_REPARACION = 15;
        RANGO_VISION = 3;

    }

    @Override
    protected int getTurnosDeConstruccionInicial() {
        return 0;
    }


    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto(){
        return COSTO;
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio(jugadorPropietario);
    }

    @Override
    public void actualizarEntreTurnos() {

    }
}
