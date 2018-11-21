package algoempires.entidad.edificio;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.jugador.Jugador;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

import java.util.HashSet;

public class Castillo extends Edificio implements Atacante {

    private final int VIDA_MAXIMA = 450;
    private final int COSTO = 0;
    private final int DANIO_A_TODO = 20;

    private HashSet<Entidad> cercanos;

    public Castillo(Jugador jugador) {
        super(jugador);

        TAMANIO_HORIZONTAL = 4;
        TAMANIO_VERTICAL = 4;
        VELOCIDAD_DE_REPARACION = 15;
        RANGO_VISION = 3;

    }

    @Override
    protected int getTurnosDeConstruccionInicial() {
        return 0;
    }


    @Override
    protected int getVidaInicial() {
        return VIDA_MAXIMA;
    }

    @Override
    protected int getCosto() {
        return COSTO;
    }

    public ArmaDeAsedio crearArmaDeAsedio() {
        return new ArmaDeAsedio(jugadorPropietario);
    }


    public void atacar(Unidad unidad) {
        unidad.restarVida(DANIO_A_TODO);
    }

    public void atacar(Edificio edificio) {
        edificio.restarVida(DANIO_A_TODO);
    }

    public boolean puedeVerA(Terreno terreno, Posicion posicionDeLaVictima) {
        return terreno.puedeEdificioVerA(this, posicionDeLaVictima);
    }

    @Override
    public boolean esDelEquipo(Jugador jugador) {
        return jugador == jugadorPropietario;
    }

    @Override
    protected int getVidaMaxima() {
        return VIDA_MAXIMA;
    }

    @Override
    public void actualizarEntreTurnos() {
        cercanos = jugadorPropietario.calcularCercanosA(this);

        this.atacarCercanos();
    }

    private void atacarCercanos() {
        for (Entidad entidad : cercanos) {
            entidad.recibirAtaqueDe(this);
        }
    }
}
