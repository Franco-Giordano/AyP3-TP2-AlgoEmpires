package interfaz.tareas;

import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import algoempires.tablero.Posicion;

public class TareaConstruirPlazaCentral implements Tarea{

    private Jugador jugadorActual;
    private Casillero casillero;

    public TareaConstruirPlazaCentral(Jugador jugadorActual){
        this.jugadorActual = jugadorActual;
    }

    public void setCasillero(Casillero casillero){
        this.casillero = casillero;
    }

    @Override
    public void ejecutar(Posicion posicionAConstruir) {
        jugadorActual.crearPlazaCentral((Aldeano) casillero.getEntidadContenida(), posicionAConstruir);
    }
}
