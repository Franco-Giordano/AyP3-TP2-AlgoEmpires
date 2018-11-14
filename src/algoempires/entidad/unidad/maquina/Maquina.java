package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Maquina extends Unidad {

    private int turnosDeConstruccion;

    public Maquina(Terreno terreno, int turnosDeConstruccionRecibidos, Casillero casilleroRecibido) {

        super(terreno, casilleroRecibido);
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
    }

}
