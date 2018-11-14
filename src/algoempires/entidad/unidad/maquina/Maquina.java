package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Maquina extends Unidad {

    private int turnosDeConstruccion;

    public Maquina(Terreno terreno, int turnosDeConstruccionRecibidos, Casillero casilleroRecibido) throws CasilleroInvalidoException {

        super(terreno, casilleroRecibido);
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
    }

}
