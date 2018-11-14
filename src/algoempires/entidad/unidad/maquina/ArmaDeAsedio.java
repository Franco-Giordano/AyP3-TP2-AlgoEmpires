package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.Terreno;

public class ArmaDeAsedio extends Maquina {

    final static int VIDA = 150;
    final static int COSTO = 200;
    final static int RANGO = 5;
    final static int DANIO_A_EDIFICIOS = 75;

    private static int turnosDeConstruccion = 1;

    public ArmaDeAsedio(Terreno terreno, Casillero casilleroRecibido) {

        super(terreno, turnosDeConstruccion, casilleroRecibido);

    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }
}

