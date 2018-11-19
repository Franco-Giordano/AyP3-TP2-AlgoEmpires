package algoempires.jugador;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

import java.util.ArrayList;
import java.util.HashMap;

public class Jugador {

    private Poblacion poblacion;
    private HashMap<Posicion, Edificio> edificiosPropios;
    private Terreno terrenoDeJuego;
    //private Posicion posicionSeleccionada; // en teoría esto va a servir cuando implementemos la interfaz.
    private Jugador jugadorContrincante;
    private Monedero monedero;

    public Jugador(Terreno terrenoDeJuego) {
        this.poblacion = new Poblacion();
        this.edificiosPropios = new HashMap<>();
        this.terrenoDeJuego = terrenoDeJuego;
        this.monedero = new Monedero();
    }

    public void setContrincante(Jugador jugador) {
        jugadorContrincante = jugador;
    }

    //TODO obtener posicion adyacente
    public void crearAldeano(Posicion posicion) {

        PlazaCentral plazaCentral = (PlazaCentral) edificiosPropios.get(posicion);
        Aldeano aldeanoCreado = plazaCentral.crearAldeano();
        Posicion posicionAdyacente = terrenoDeJuego.obtenerPosicionAdyacente(posicion);
        poblacion.agregar(aldeanoCreado);
        terrenoDeJuego.ocupar(posicionAdyacente,aldeanoCreado);

    }

    public void jugarTurno() {


    }

    public void sumarOro(int oro) {
        monedero.sumarOro(oro);
    }


    //METODO DE TESTEO
    public int getOro() {
        return monedero.getOro();
    }

    public void asignarAlJugador(Posicion posicion, Entidad entidad) {

        edificiosPropios.put(posicion,(Edificio)entidad);
    }
}
