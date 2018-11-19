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

    private HashSet<Edificio> entidadesReparables;

    public Aldeano() throws PosicionInvalidaException {

        super();
        this.estaTrabajando = false;
        this.entidadesReparables = null;

        RANGO_VISION = 1;
        COSTO = 25;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    public void construirPlazaCentral() throws PosicionInvalidaException {

        new PlazaCentral();
        estaTrabajando = true;

    }

    public void construirCuartel() throws PosicionInvalidaException {

        new Cuartel();
        estaTrabajando = true;

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

    public void setReparables(HashSet<Edificio> listaRecibida) {
        this.entidadesReparables = listaRecibida;
    }

    //METODOS DE TESTEOS UNICAMENTE
    public boolean tieneEstasCaracteristicas(int vida, int oroGenerado, boolean estaTrabajando) {
        return (vida == this.VIDA_INICIAL && this.ORO_GENERADO == oroGenerado && this.estaTrabajando == estaTrabajando);
    }

    public void imprimirListaDeReparables() {
        for (Edificio each : this.entidadesReparables) {
            System.out.println(each);
        }
    }

}
