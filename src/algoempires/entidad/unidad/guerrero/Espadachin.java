package algoempires.entidad.unidad.guerrero;

import algoempires.Coordenada;

public class Espadachin extends Guerrero {

    private static int vida = 100;
    private static int costo = 50;
    private static int rango = 1;
    private static int danioAUnidades = 25;
    private static int danioAEdificios = 15;

    public Espadachin(Coordenada coordenadaRecibida) {

        super(vida, costo, rango, danioAUnidades, danioAEdificios, coordenadaRecibida);

    }

}
