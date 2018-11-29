package interfaz;

import interfaz.tareas.Tarea;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EstadoEnEsperaDeClickHandler implements EventHandler<MouseEvent> {

    private Tarea tarea;

    public EstadoEnEsperaDeClickHandler(Tarea tarea){
        this.tarea = tarea;
    }

    @Override
    public void handle(MouseEvent event) {
       tarea.ejecutar();
    }
}
