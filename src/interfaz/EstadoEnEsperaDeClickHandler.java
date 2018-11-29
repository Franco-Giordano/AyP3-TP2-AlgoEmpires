package interfaz;

import algoempires.tablero.Posicion;
import interfaz.tareas.Tarea;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EstadoEnEsperaDeClickHandler implements EventHandler<MouseEvent> {

    private Posicion posicionReceptora;
    private Tarea tarea;
    private VistaPartidaController vistaController;

    public EstadoEnEsperaDeClickHandler(Tarea tarea, Posicion posReceptora, VistaPartidaController vistaController) {
        this.tarea = tarea;
        this.posicionReceptora = posReceptora;
        this.vistaController = vistaController;
    }

    @Override
    public void handle(MouseEvent event) {
        tarea.ejecutar(posicionReceptora);
        vistaController.crearCasilleros();
    }
}
