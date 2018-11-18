package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;

import java.util.ArrayList;
import java.util.HashSet;

public class Aldeano extends Unidad {

    private final int ORO_GENERADO = 20;
    private final int VIDA = 50;
    private final int RANGO_REPARACION = 1;
    private boolean estaTrabajando;

    private HashSet<Edificio> entidadesReparables;

    public Aldeano() throws CasilleroInvalidoException {

        super();
        this.estaTrabajando = false;
        this.entidadesReparables = null;

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

    @Override
    public int getRango() {
        return RANGO_REPARACION;
    }

    //METODO DE TESTEO UNICAMENTE
    public boolean tieneEstasCaracteristicas(int vida, int oroGenerado, boolean estaTrabajando) {
        return (vida == this.getVidaInicial() && this.ORO_GENERADO == oroGenerado && this.estaTrabajando == estaTrabajando);
    }

    public void setReparables(HashSet<Edificio> listaRecibida) {
        this.entidadesReparables = listaRecibida;
    }

    public void imprimirListaDeReparables() {
        for (Edificio each : this.entidadesReparables) {
            System.out.println(each);
        }
    }

}
