package interfaz.controller.tareas;

import algoempires.entidad.edificio.PlazaCentral;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.view.CasilleroView;

public class TareaCrearAldeano implements Tarea {
    private Jugador jugadorActual;
    private Casillero casilleroEmisor;

    public TareaCrearAldeano(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicionACrear) {
        jugadorActual.crearAldeano((PlazaCentral) casilleroEmisor.getEntidadContenida(), posicionACrear);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}
