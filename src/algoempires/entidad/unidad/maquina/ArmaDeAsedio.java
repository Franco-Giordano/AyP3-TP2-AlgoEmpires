package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;

public class ArmaDeAsedio extends Maquina {

    private static int vida = 150;
    private static int costo = 200;
    private static int rango = 5;
    private static int turnosDeConstruccion = 1;
    private static int danioAEdificios = 75;

    public ArmaDeAsedio(int vidaRecibida, int costoRecibido, int rangoRecibido,
                        int turnosDeConstruccionRecibidos, int danioAEdificiosRecibido, Casillero casilleroRecibido) {

        super(vidaRecibida, costoRecibido, rangoRecibido, turnosDeConstruccionRecibidos, danioAEdificiosRecibido, casilleroRecibido);

    }
}
