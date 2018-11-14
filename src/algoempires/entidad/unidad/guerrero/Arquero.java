package algoempires.entidad.unidad.guerrero;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;

public class Arquero extends Guerrero {

    private final int VIDA_INICIAL = 75;
    private static int rangoDelArquero = 3;
    private static int danioAUnidades = 15;
    private static int danioAEdificios = 10;

    public Arquero(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(rangoDelArquero, terreno, danioAUnidades, danioAEdificios, casillero);

    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }


    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }

}
