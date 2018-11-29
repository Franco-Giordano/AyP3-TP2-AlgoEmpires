package interfaz;

import algoempires.tablero.Posicion;
import interfaz.tareas.Tarea;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EstadoEnEsperaDeClickHandler implements EventHandler<MouseEvent> {

    private final Posicion posicionReceptora;
    private Tarea tarea;

    public EstadoEnEsperaDeClickHandler(Tarea tarea, Posicion posReceptora) {
        this.tarea = tarea;
        this.posicionReceptora = posReceptora;
    }

    @Override
    public void handle(MouseEvent event) {
        tarea.ejecutar(posicionReceptora);
    }
}
