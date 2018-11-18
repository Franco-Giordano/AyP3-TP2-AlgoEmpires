package algoempires.entidad.unidad.utilero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;

import java.util.ArrayList;

public class Aldeano extends Unidad {

    private final int ORO_GENERADO = 20;
    private final int VIDA = 50;
    private boolean estaTrabajando;

    private ArrayList<Entidad> reparables;

    public Aldeano() throws CasilleroInvalidoException {

        super();
        this.estaTrabajando = false;

    }

    public void construirPlazaCentral() throws CasilleroInvalidoException {

        new PlazaCentral();
        estaTrabajando = true;

    }

    public void construirCuartel() throws CasilleroInvalidoException {

        new Cuartel();
        estaTrabajando = true;

    }

    public void reparar(Posicion posicion) {


        estaTrabajando = true;

    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
        if (!estaTrabajando) {
            jugador.sumarOro(ORO_GENERADO);
        }
    }

    //METODO DE TESTEO UNICAMENTE
    public boolean tieneEstasCaracteristicas(int vida, int oroGenerado, boolean estaTrabajando) {
        return (vida == this.getVidaInicial() && this.ORO_GENERADO == oroGenerado && this.estaTrabajando == estaTrabajando);
    }

}
