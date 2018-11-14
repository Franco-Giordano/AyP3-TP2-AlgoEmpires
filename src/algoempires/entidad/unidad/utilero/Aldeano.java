package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;

public class Aldeano extends Utilero {

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
}
