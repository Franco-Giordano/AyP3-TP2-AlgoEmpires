package interfaz.tareas;

import algoempires.entidad.Atacante;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;

public class TareaAtacar implements Tarea {
    private Casillero casilleroEmisor;
    private Jugador jugadorActual;

    public TareaAtacar(Jugador jugadorActual, Casillero casilleroEmisor) {
        this.jugadorActual = jugadorActual;
        this.casilleroEmisor = casilleroEmisor;
    }

    @Override
    public void ejecutar(Posicion posicion) {
        jugadorActual.atacar((Atacante) casilleroEmisor.getEntidadContenida(), posicion);
    }
}
