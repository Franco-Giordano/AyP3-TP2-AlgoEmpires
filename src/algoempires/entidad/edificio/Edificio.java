package algoempires.entidad.edificio;

import algoempires.Region;
import algoempires.Terreno;
import algoempires.entidad.Entidad;

public abstract class Edificio extends Entidad {

    private int turnosDeConstruccion;
    private Region espacioQueOcupa;

    public Edificio(int vidaRecibida, int costoRecibido, Terreno terreno, int turnosDeConstruccionRecibidos, Region espacioQueOcupaRecibido) {
        super(vidaRecibida, costoRecibido, terreno);
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
        this.espacioQueOcupa = espacioQueOcupaRecibido;
        espacioQueOcupa.ocupar(this);
    }

    public int getTurnos(){
        return this.turnosDeConstruccion;
    }

    public void setTurnosDeConstruccion(int turnosRecibidos){
        this.turnosDeConstruccion = turnosRecibidos;
    }

}
