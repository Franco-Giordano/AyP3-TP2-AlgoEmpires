package algoempires.entidad.unidad.maquina;

import algoempires.Coordenada;

public class ArmaDeAsedio extends Maquina {

    private static int vida = 150;
    private static int costo = 200;
    private static int rango = 5;
    private static int turnosDeConstruccion = 1;
    private static int danioAEdificios = 75;

    public ArmaDeAsedio(int vidaRecibida, int costoRecibido, int rangoRecibido,
                        int turnosDeConstruccionRecibidos, int danioAEdificiosRecibido, Coordenada coordenadaRecibida) {

        super(vidaRecibida, costoRecibido, rangoRecibido, turnosDeConstruccionRecibidos, danioAEdificiosRecibido, coordenadaRecibida);

    }
}
