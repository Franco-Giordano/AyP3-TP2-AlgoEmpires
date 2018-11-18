package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.unidad.Unidad;

public abstract class Guerrero extends Unidad {


    public Guerrero() {

        super();
    }

    protected abstract int getRangoAtaque();

    protected abstract int getDanioAUnidades();

    protected abstract int getDanioAEdificios();


}
