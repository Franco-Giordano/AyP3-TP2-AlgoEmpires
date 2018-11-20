package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

import java.util.HashSet;

public abstract class Guerrero extends Unidad {

    protected int DANIO_A_UNIDADES;
    protected int DANIO_A_EDIFICIOS;


    public Guerrero() {

        super();
    }

    public abstract void atacar(Unidad unidad);

    public abstract void atacar(Edificio edificio);

}
