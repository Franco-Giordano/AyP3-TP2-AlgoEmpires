package algoempires.entidad.unidad.guerrero;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;

public class Espadachin extends Guerrero {

    private final int VIDA = 100;
    private final int COSTO = 50;
    private static int rango = 1;
    private static int danioAUnidades = 25;
    private static int danioAEdificios = 15;

    public Espadachin(Terreno terreno, Casillero casilleroRecibido) throws CasilleroInvalidoException {

        super(rango, terreno, danioAUnidades, danioAEdificios, casilleroRecibido);

    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }

}
