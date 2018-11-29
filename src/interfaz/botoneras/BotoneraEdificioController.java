package interfaz.botoneras;

import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import interfaz.VistaPartidaController;
import interfaz.tareas.Tarea;
import interfaz.tareas.TareaCrearArquero;

public class BotoneraEdificioController {

    private Casillero casillero;
    private Jugador jugadorActual;
    private VistaPartidaController vistaController;

    public void setVistaController(VistaPartidaController vistaController) {
        this.vistaController = vistaController;
    }

    public void setRegion(Casillero casillero) {
        this.casillero = casillero;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void crearArquero() {
        Tarea tareaCrearAldeano = new TareaCrearArquero(jugadorActual, casillero);
        vistaController.setHandlersEnEsperaConTarea(tareaCrearAldeano);

    }


}
