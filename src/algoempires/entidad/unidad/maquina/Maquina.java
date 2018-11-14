package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Maquina extends Unidad {

    private int rango;
    private int turnosDeConstruccion;
    private int danioAEdificios;

    public Maquina(int vidaRecibida, int costoRecibido, Terreno terreno,
                   int rangoRecibido, int turnosDeConstruccionRecibidos,
                   int danioAEdificiosRecibido, Casillero casilleroRecibido) {

        super(terreno, casilleroRecibido);
        this.rango = rangoRecibido;
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
        this.danioAEdificios = danioAEdificiosRecibido;

    }
}
