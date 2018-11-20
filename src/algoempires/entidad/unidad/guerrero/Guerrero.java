package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;

public abstract class Guerrero extends Unidad {

    protected int DANIO_A_UNIDADES;
    protected int DANIO_A_EDIFICIOS;


    public Guerrero(Jugador jugador) {

        super(jugador);
    }

    public abstract void atacar(Unidad unidad);

    public abstract void atacar(Edificio edificio);

}
