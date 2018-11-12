package algoempires.entidad.unidad.maquina;

import algoempires.Coordenada;
import algoempires.entidad.unidad.Unidad;

public abstract class Maquina extends Unidad {

    private int rango;
    private int turnosDeConstruccion;
    private int danioAEdificios;

    public Maquina(int vidaRecibida, int costoRecibido, int rangoRecibido, int turnosDeConstruccionRecibidos,
                   int danioAEdificiosRecibido, Coordenada coordenadaRecibida) {

        super(vidaRecibida, costoRecibido, coordenadaRecibida);
        this.rango = rangoRecibido;
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
        this.danioAEdificios = danioAEdificiosRecibido;

    }
}
