package algoempires.entidad.unidad.guerrero;

import algoempires.Casillero;

public class Espadachin extends Guerrero {

    private static int vida = 100;
    private static int costo = 50;
    private static int rango = 1;
    private static int danioAUnidades = 25;
    private static int danioAEdificios = 15;

    public Espadachin(Casillero casilleroRecibido) {

        super(vida, costo, rango, danioAUnidades, danioAEdificios, casilleroRecibido);

    }

}
