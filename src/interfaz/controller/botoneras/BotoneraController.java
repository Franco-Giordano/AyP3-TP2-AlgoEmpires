package interfaz.controller.botoneras;

import algoempires.jugador.Jugador;
import algoempires.tablero.Casillero;
import interfaz.controller.VistaPartidaController;

public interface BotoneraController {

    void setCasillero(Casillero casillero);

    void setJugadorActual(Jugador jugadorActual);

    void setVistaController(VistaPartidaController vista);
}
