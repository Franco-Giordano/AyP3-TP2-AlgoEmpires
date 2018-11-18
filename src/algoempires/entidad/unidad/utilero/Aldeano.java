package algoempires.entidad.unidad.utilero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Posicion;
import algoempires.tablero.Region;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Aldeano extends Unidad {

    private final int ORO_GENERADO = 20;
    private final int VIDA = 50;
    private final int RANGO_REPARACION = 1;
    private boolean estaTrabajando;

    private ArrayList<Edificio> entidadesReparables;

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


    public int getRango(){
        return RANGO_REPARACION;
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

    public ArrayList<Posicion> generarRangoAPartirDePosicion(Posicion posicionRecibida){
        Region region = new Region(posicionRecibida, this.getRango(), this.getRango());
        return region.generarRango(this,posicionRecibida);
    }

    public void setReparables(ArrayList<Edificio> listaRecibida){
        this.entidadesReparables = listaRecibida;
    }

    public void imprimirListaDeReparables() {
        for (Edificio each: this.entidadesReparables){
            System.out.println(each);
        }
    }
}
