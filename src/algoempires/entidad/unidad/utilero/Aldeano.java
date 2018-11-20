package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;

import java.util.HashSet;

public class Aldeano extends Unidad {

    private final int VIDA_INICIAL = 50;

    private final int ORO_GENERADO = 20;
    private boolean estaTrabajando;

    public Aldeano() throws PosicionInvalidaException {

        super();
        this.estaTrabajando = false;

        RANGO_VISION = 1;
        COSTO = 25;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    public PlazaCentral construirPlazaCentral() throws PosicionInvalidaException {

        estaTrabajando = true;

        return new PlazaCentral();
    }

    public Cuartel construirCuartel() throws PosicionInvalidaException {

        estaTrabajando = true;

        return new Cuartel();
    }

    public void reparar(Posicion posicion) {


        estaTrabajando = true;

    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
        if (!estaTrabajando) {
            jugador.sumarOro(ORO_GENERADO);
        }
    }

}
