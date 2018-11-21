package algoempires.entidad.unidad.guerrero.armadeasedio;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Guerrero;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;


public class ArmaDeAsedio extends Guerrero {

    private final int VIDA_INICIAL = 50;
    private final int COSTO = 200;

    private EstadoArmaDeAsedio estadoActual;

    public ArmaDeAsedio(Jugador jugador) throws PosicionInvalidaException {

        super(jugador);

        this.estadoActual = new EstadoMovible();

        RANGO_VISION = 5;
        DANIO_A_EDIFICIOS = 75;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }

    public void montar() {
        estadoActual = new EstadoMontando();
    }

    public void desmontar() {
        estadoActual = new EstadoDesmontando();
    }

    @Override
    public void atacar(Unidad unidad) throws ArmaDeAsedioNoPuedeAtacarUnidades {
        throw new ArmaDeAsedioNoPuedeAtacarUnidades();
    }

    @Override
    public void atacar(Edificio edificio) {

        if (!estadoActual.puedeAtacar()) {
            throw new ArmaDeAsedioNoPuedeAtacarSinEstarMontadaException("Se intento atacar sin haber montado antes");
        }

        super.atacar(edificio);
    }

    @Override
    public void actualizarEntreTurnos() {
        super.actualizarEntreTurnos();
        this.estadoActual = estadoActual.actualizarEntreTurnos();
    }


    @Override
    public boolean esDelEquipo(Jugador jugador) {
        return jugador == jugadorPropietario;
    }

    @Override
    public boolean sePuedeMover() {
        return this.estadoActual.sePuedeMover() && super.sePuedeMover();
    }
}

