package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Terreno;

public class Aldeano extends Unidad {

    private final int ORO_GENERADO = 20;
    private final int VIDA = 50;
    private boolean estaTrabajando;

    public Aldeano(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {

        super(terreno, casillero);
        this.estaTrabajando = false;
    }

    public void construirPlazaCentral(Casillero casillero) throws CasilleroInvalidoException {

        new PlazaCentral(terrenoDeJuego, casillero);
        estaTrabajando = true;

    }

    public void construirCuartel(Casillero casillero) throws CasilleroInvalidoException {

        new Cuartel(terrenoDeJuego, casillero);
        estaTrabajando = true;

    }

    public void reparar(Casillero casillero) {

        terrenoDeJuego.reparar(casillero);
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
