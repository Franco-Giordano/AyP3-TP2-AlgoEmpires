package interfaz.controller.tareas;

import algoempires.tablero.Posicion;
import interfaz.view.CasilleroView;

public interface Tarea {

    void ejecutar(Posicion posicion);

    void realizarTareasOpcionales(CasilleroView casilleroView);

}
