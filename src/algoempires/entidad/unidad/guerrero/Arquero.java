package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;

public class Arquero extends Guerrero {

    private final int VIDA_INICIAL = 50;

    public Arquero() {
        super();

        RANGO_VISION = 3;
        DANIO_A_UNIDADES = 15;
        DANIO_A_EDIFICIOS = 10;
        COSTO = 75;
    }

    @Override
    protected int getVidaInicial() {
        return VIDA_INICIAL;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }


    public boolean tieneEstasCaracteristicas(int vida, int rango, int danioUnidades, int danioEdificios) {
        return ((this.VIDA_INICIAL == vida) && (this.RANGO_VISION == rango)
                && (this.DANIO_A_EDIFICIOS == danioEdificios) && (this.DANIO_A_UNIDADES == danioUnidades));

    }

    @Override
    public void atacar(Unidad unidad){
        unidad.restarVida(DANIO_A_UNIDADES);
    }

    @Override
    public void atacar(Edificio edificio){
        edificio.restarVida(DANIO_A_EDIFICIOS);
    }

}
