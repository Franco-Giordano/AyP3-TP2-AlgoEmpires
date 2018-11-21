package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;

public class Aldeano extends Unidad {

    private final int VIDA_INICIAL = 50;

    private final int ORO_GENERADO = 20;

    private boolean estaTrabajando;

    public Aldeano(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);
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

        return new PlazaCentral(jugadorPropietario);
    }

    public Cuartel construirCuartel() throws PosicionInvalidaException {

        estaTrabajando = true;

        return new Cuartel(jugadorPropietario);
    }

    public void reparar(Edificio edificioRecibido) {

        edificioRecibido.reparar();

        this.estaTrabajando = true;
    }

    @Override
    public void actualizarEntreTurnos() {
        if (!estaTrabajando) {
            jugadorPropietario.sumarOro(ORO_GENERADO);
        }
    }

}
