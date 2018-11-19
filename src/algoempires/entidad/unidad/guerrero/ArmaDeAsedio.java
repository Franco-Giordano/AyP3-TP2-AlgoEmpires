package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.PosicionInvalidaException;


public class ArmaDeAsedio extends Guerrero {

    private final int VIDA_INICIAL = 50;
    private final int TURNOS_DE_CONSTRUCCION_INICIAL = 1;

    private int turnosDeConstruccion;

    private boolean estaMontada;

    public ArmaDeAsedio() throws PosicionInvalidaException {

        super();

        this.turnosDeConstruccion = TURNOS_DE_CONSTRUCCION_INICIAL;

        this.estaMontada = false;

        RANGO_VISION = 5;
        DANIO_A_EDIFICIOS = 75;

    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    public void montar() {
        estaMontada = true;
    }

    /*public void desmontar() {
        estaMontada = false;
    }*/

    @Override
    public void atacar(Unidad unidad) throws ArmaDeAsedioNoPuedeAtacarUnidades {
        throw new ArmaDeAsedioNoPuedeAtacarUnidades();
    }

    @Override
    public void atacar(Edificio edificio){
        edificio.restarVida(DANIO_A_EDIFICIOS);
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }

    public boolean tieneEstasCaracteristicas(int vida, int rangoAtaque, int turnosDeConstruccion, int danioAEdficios, boolean estaMontada) {
        return ((this.VIDA_INICIAL == vida) && (this.DANIO_A_EDIFICIOS == danioAEdficios)
                && (this.estaMontada == estaMontada) && (this.RANGO_VISION == rangoAtaque)
                && (this.turnosDeConstruccion == turnosDeConstruccion));
    }

    //METODO DE PRUEBAS.
    public void imprimirListaDeEntidades() {

        if (!this.atacables.isEmpty()) {
            for (Entidad each : this.atacables) {
                System.out.println(each);
            }
        }else {
            System.out.println("Esta unidad no ve a nadie.");
        }
    }
}

