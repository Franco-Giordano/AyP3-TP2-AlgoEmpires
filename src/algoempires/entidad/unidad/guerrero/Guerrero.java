package algoempires.entidad.unidad.guerrero;

import algoempires.entidad.Atacante;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

public abstract class Guerrero extends Unidad implements Atacante {

    protected int DANIO_A_UNIDADES;
    protected int DANIO_A_EDIFICIOS;
    private boolean yaAtacoEsteTurno;

    public Guerrero(Jugador jugador) {

        super(jugador);
        yaAtacoEsteTurno = false;
    }

    public void atacar(Unidad unidad) {

        if (!puedeAtacarEsteTurno()) {
            throw new GuerreroYaAtacoEsteTurnoException("Un Guerrero intento atacar una unidad, cuando ya habia atacado este turno");
        }

        unidad.restarVida(DANIO_A_UNIDADES);
        yaAtacoEsteTurno = true;

    }

    public void atacar(Edificio edificio) {

        if (!puedeAtacarEsteTurno()) {
            throw new GuerreroYaAtacoEsteTurnoException("Un Guerrero intento atacar un edificio, cuando ya habia atacado este turno");
        }

        edificio.restarVida(DANIO_A_EDIFICIOS);
        yaAtacoEsteTurno = true;

    }

    private boolean puedeAtacarEsteTurno() {
        return !yaAtacoEsteTurno;
    }

    public boolean puedeVerA(Terreno terreno, Posicion posicionVictima) {
        return terreno.puedeUnidadVerA(this, posicionVictima);
    }

    @Override
    public void actualizarEntreTurnos() {
        super.actualizarEntreTurnos();
        yaAtacoEsteTurno = false;
    }

}
