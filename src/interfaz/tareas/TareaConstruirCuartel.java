package interfaz.tareas;

import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.CasilleroView;

public class TareaConstruirCuartel implements Tarea {

    private Jugador jugadorActual;
    private Casillero casilleroEmisor;

    public TareaConstruirCuartel(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicionAConstruir) {
        jugadorActual.crearCuartel((Aldeano) casilleroEmisor.getEntidadContenida(), posicionAConstruir);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}
