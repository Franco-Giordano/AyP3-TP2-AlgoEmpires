package interfaz.controller.tareas;

import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;
import interfaz.view.CasilleroView;

public class TareaRepararEdificio implements Tarea {

    private Casillero casilleroEmisor;
    private Jugador jugadorActual;

    public TareaRepararEdificio(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicion) {
        jugadorActual.reparar((Aldeano) casilleroEmisor.getEntidadContenida(), posicion);
    }

    @Override
    public void realizarTareasOpcionales(CasilleroView casilleroView) {

    }
}
