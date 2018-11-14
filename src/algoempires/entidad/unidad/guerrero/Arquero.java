package algoempires.entidad.unidad.guerrero;

import algoempires.Casillero;
import algoempires.Terreno;

public class Arquero extends Guerrero {

    private static int vidaDelArquero = 75;
    private static int costoDelArquero = 75;
    private static int rangoDelArquero = 3;
    private static int danioAUnidades = 15;
    private static int danioAEdificios = 10;

    public Arquero(Terreno terreno, Casillero casillero) {
        super(vidaDelArquero, costoDelArquero, rangoDelArquero,terreno, danioAUnidades, danioAEdificios, casillero);

    }

}
