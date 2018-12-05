package interfaz.tareas;

import algoempires.entidad.Atacante;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.CasilleroView;

public class TareaAtacar implements Tarea {
    private Casillero casilleroEmisor;
    private Jugador jugadorActual;
    private boolean ataqueExitoso;

    public TareaAtacar(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicion) {
        ataqueExitoso = jugadorActual.atacar((Atacante) casilleroEmisor.getEntidadContenida(), posicion);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroViewReceptor) {
        Class clase = casilleroViewReceptor.getCasillero().getEntidadContenida().getClass();
        if (clase == PlazaCentral.class || clase == Cuartel.class || clase == Castillo.class) {
            if (ataqueExitoso) {
                casilleroViewReceptor.reproducirAnimacion("animacionDanioEdificio");
            }
        } else {
            if (ataqueExitoso) {
                casilleroViewReceptor.reproducirAnimacion("animacionDanioUnidad");
            }
        }

    }
}
