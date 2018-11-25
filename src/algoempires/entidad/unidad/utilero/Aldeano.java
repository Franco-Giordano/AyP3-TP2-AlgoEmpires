package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;

public class Aldeano extends Unidad {

    private final int VIDA_INICIAL = 50;

    private final int ORO_GENERADO = 20;

    private final int COSTO = 25;

    private EstadoAldeano estadoActual;

    public Aldeano(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);

        RANGO_VISION = 1;

        this.estadoActual = new EstadoRecolectandoOro(this);
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }

    public PlazaCentral construirPlazaCentral() throws PosicionInvalidaException {

        PlazaCentral plazaCentral = new PlazaCentral(jugadorPropietario);

        this.estadoActual = new EstadoConstruyendo(this, plazaCentral);

        return plazaCentral;
    }

    public Cuartel construirCuartel() throws PosicionInvalidaException {

        Cuartel cuartel = new Cuartel(jugadorPropietario);

        this.estadoActual = new EstadoConstruyendo(this, cuartel);

        return cuartel;
    }

    public void ordenarReparacion(Edificio edificioRecibido) {

        this.estadoActual = new EstadoReparando(this, edificioRecibido);

    }

    @Override
    public boolean sePuedeMover() {
        return estadoActual.sePuedeMover() && super.sePuedeMover();
    }

    @Override
    public void actualizarEntreTurnos() {
        super.actualizarEntreTurnos();
        this.estadoActual = estadoActual.actualizarEntreTurnos();
    }

    public void generarOro() {
        jugadorPropietario.sumarOro(ORO_GENERADO);
    }
}
