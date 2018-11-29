package interfaz.tareas;

import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;

public interface Tarea {

    void ejecutar(Posicion posicion);

    void setCasillero(Casillero casillero);
}
