package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public class Aldeano extends Unidad {

    private final int ORO_GENERADO = 20;
    private final int VIDA = 50;
    private boolean estaTrabajando;

    public Aldeano(Terreno terreno, Posicion posicion) throws CasilleroInvalidoException {

        super(terreno, posicion);
        this.estaTrabajando = false;
    }

    public void construirPlazaCentral(Posicion posicion) throws CasilleroInvalidoException {

        new PlazaCentral(terrenoDeJuego, posicion);
        estaTrabajando = true;

    }

    public void construirCuartel(Posicion posicion) throws CasilleroInvalidoException {

        new Cuartel(terrenoDeJuego, posicion);
        estaTrabajando = true;

    }

    public void reparar(Posicion posicion) {

        terrenoDeJuego.reparar(posicion);
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
    public boolean tieneEstasCaracteristicas(int vida, int oroGenerado, boolean estaTrabajando){
        return (vida == this.getVidaInicial() && this.ORO_GENERADO == oroGenerado && this.estaTrabajando == estaTrabajando);
    }

}
