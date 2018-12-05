package interfaz;

import algoempires.tablero.Posicion;
import interfaz.tareas.Tarea;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class EstadoEnEsperaDeClickHandler implements EventHandler<MouseEvent> {

    private CasilleroView casilleroViewReceptor;
    private Tarea tarea;
    private VistaPartidaController vistaController;

    public EstadoEnEsperaDeClickHandler(Tarea tarea, CasilleroView casilleroReceptor, VistaPartidaController vistaController) {
        this.tarea = tarea;
        this.casilleroViewReceptor = casilleroReceptor;
        this.vistaController = vistaController;
    }

    @Override
    public void handle(MouseEvent event) {
        Posicion posicion = casilleroViewReceptor.getCasillero().getPosicion();
        tarea.ejecutar(posicion);
        vistaController.crearCasilleros();
        tarea.realizarTareasOpcionales(vistaController.getCasilleroViewEnPosicion(posicion));
    }
}
