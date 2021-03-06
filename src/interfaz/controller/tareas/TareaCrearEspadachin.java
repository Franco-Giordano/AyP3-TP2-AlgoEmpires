package interfaz.controller.tareas;

import algoempires.entidad.edificio.Cuartel;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.view.CasilleroView;


public class TareaCrearEspadachin implements Tarea {

    private Jugador jugadorActual;
    private Casillero casilleroEmisor;

    public TareaCrearEspadachin(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicionACrear) {
        jugadorActual.crearEspadachin((Cuartel) casilleroEmisor.getEntidadContenida(), posicionACrear);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}

