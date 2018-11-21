package algoempires.entidad;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

public interface Atacante {

    void atacar(Unidad unidad);

    void atacar(Edificio edificio);

    boolean puedeVerA(Terreno terreno, Posicion posicionDeLaVictima);
}
