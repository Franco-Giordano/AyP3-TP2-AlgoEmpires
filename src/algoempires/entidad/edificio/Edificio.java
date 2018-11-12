package algoempires.entidad.edificio;

import algoempires.Region;
import algoempires.entidad.Entidad;

public class Edificio extends Entidad {

    private int turnosDeConstruccion;
    private Region espacioQueOcupa;

    public Edificio(int vidaRecibida, int costoRecibido, int turnosDeConstruccionRecibidos, Region espacioQueOcupaRecibido) {
        super(vidaRecibida, costoRecibido);
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
        this.espacioQueOcupa = espacioQueOcupaRecibido;
        espacioQueOcupa.ocupar(this);
    }


}
