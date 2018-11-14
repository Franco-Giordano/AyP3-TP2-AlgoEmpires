package algoempires.entidad.unidad.guerrero;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.unidad.Unidad;

public abstract class Guerrero extends Unidad {

    private int rango;
    private int danioAUnidades;
    private int danioAEdificios;

    public Guerrero(int vidaRecibida, int costoRecibido, int rangoRecibido, Terreno terreno,
                    int danioAUnidadesRecibido, int danioAEdificiosRecibido, Casillero casilleroRecibido) {

        super(vidaRecibida, costoRecibido,terreno,  casilleroRecibido);
        this.rango = rangoRecibido;
        this.danioAUnidades = danioAUnidadesRecibido;
        this.danioAEdificios = danioAEdificiosRecibido;
    }

}
