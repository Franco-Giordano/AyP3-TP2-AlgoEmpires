package interfaz.tareas;

import algoempires.entidad.edificio.Cuartel;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.CasilleroView;

public class TareaCrearArquero implements Tarea {

    private Jugador jugadorActual;
    private Casillero casilleroEmisor;

    public TareaCrearArquero(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicionACrear) {
        jugadorActual.crearArquero((Cuartel) casilleroEmisor.getEntidadContenida(), posicionACrear);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}
