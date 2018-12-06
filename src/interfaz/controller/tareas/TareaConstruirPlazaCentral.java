package interfaz.controller.tareas;

import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.view.CasilleroView;

public class TareaConstruirPlazaCentral implements Tarea {

    private Jugador jugadorActual;
    private Casillero casilleroEmisor;

    public TareaConstruirPlazaCentral(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicionAConstruir) {
        jugadorActual.crearPlazaCentral((Aldeano) casilleroEmisor.getEntidadContenida(), posicionAConstruir);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}
