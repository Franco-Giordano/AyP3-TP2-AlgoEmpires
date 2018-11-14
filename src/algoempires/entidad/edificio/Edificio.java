package algoempires.entidad.edificio;

import algoempires.Terreno;
import algoempires.entidad.Entidad;

public abstract class Edificio extends Entidad {

    private int turnosDeConstruccion;

    public Edificio(int vidaRecibida, int costoRecibido, Terreno terreno, int turnosDeConstruccionRecibidos) {
        super(vidaRecibida, costoRecibido, terreno);
        this.turnosDeConstruccion = turnosDeConstruccionRecibidos;
    }

    public int getTurnos(){
        return this.turnosDeConstruccion;
    }

    public void setTurnosDeConstruccion(int turnosRecibidos){
        this.turnosDeConstruccion = turnosRecibidos;
    }

}
