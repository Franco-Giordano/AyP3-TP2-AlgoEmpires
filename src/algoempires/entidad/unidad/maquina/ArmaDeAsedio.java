package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.Terreno;

public class ArmaDeAsedio extends Maquina {

    final static int VIDA = 150;
    final static int COSTO = 200;

    private static int rango = 5;
    private static int turnosDeConstruccion = 1;
    private static int danioAEdificios = 75;

    public ArmaDeAsedio(int vidaRecibida, int costoRecibido, Terreno terreno,
                        int rangoRecibido,
                        int turnosDeConstruccionRecibidos, int danioAEdificiosRecibido, Casillero casilleroRecibido) {

        super(vidaRecibida, costoRecibido, terreno, rangoRecibido, turnosDeConstruccionRecibidos, danioAEdificiosRecibido, casilleroRecibido);

    }

    @Override
    protected int getVidaInicial(){
        return VIDA;
    }

    @Override
    protected int getCosto(){
        return COSTO;
    }
}

