package interfaz.tareas;

import algoempires.tablero.Posicion;
import interfaz.CasilleroView;

public interface Tarea {

    void ejecutar(Posicion posicion);

    void realizarTareasOpcionales(CasilleroView casilleroView);

}
