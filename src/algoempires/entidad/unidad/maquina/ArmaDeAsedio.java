package algoempires.entidad.unidad.maquina;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Jugador;
import algoempires.Terreno;
import algoempires.direccion.Direccion;
import algoempires.entidad.unidad.UnidadYaMovioEnEsteTurnoException;

public class ArmaDeAsedio extends Maquina {

    private final int VIDA = 150;
    private final int COSTO = 200;
    private final int RANGO = 5;
    private final int DANIO_A_EDIFICIOS = 75;

    private static int turnosDeConstruccion = 1;

    private boolean estaMontada;

    public ArmaDeAsedio(Terreno terreno, Casillero casilleroRecibido) throws CasilleroInvalidoException {

        super(terreno, turnosDeConstruccion, casilleroRecibido);

        this.estaMontada = false;

    }

    public void montar() {
        estaMontada = true;
    }

    public void desmontar() {
        estaMontada = false;
    }

    @Override
    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException, UnidadYaMovioEnEsteTurnoException {
        if (!estaMontada) {
            super.desplazarHacia(direccion);
        }
    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    public void actualizarEntreTurnos(Jugador jugador) {
    }


}

