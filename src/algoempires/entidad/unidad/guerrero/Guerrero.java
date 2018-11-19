package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Posicion;

import java.util.HashSet;

public abstract class Guerrero extends Unidad {

    protected HashSet<Entidad> atacables;

    public Guerrero() {

        super();
    }

    public abstract void atacar(Unidad unidad);

    public abstract void atacar(Edificio edificio);

    public abstract int getRango();

    protected abstract int getDanioAUnidades();

    protected abstract int getDanioAEdificios();

    public void setAtacables(HashSet<Entidad> atacablesRecibidos){
        this.atacables = atacablesRecibidos;
    }

}
