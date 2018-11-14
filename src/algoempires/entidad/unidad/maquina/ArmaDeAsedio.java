package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;

public class ArmaDeAsedio extends Maquina {

    private final static int VIDA = 150;
    private final static int COSTO = 200;
    private final static int RANGO = 5;
    private final static int DANIO_A_EDIFICIOS = 75;

    private static int turnosDeConstruccion = 1;

    public ArmaDeAsedio(Terreno terreno, Casillero casilleroRecibido) throws CasilleroInvalidoException {

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

