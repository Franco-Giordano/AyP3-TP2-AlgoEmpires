package algoempires.jugador;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Guerrero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

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
    public void crearAldeano(Posicion unaPosicionDeLaPlaza, Posicion posicionDeCreacion) {

        PlazaCentral plazaCentral = (PlazaCentral) edificiosPropios.get(unaPosicionDeLaPlaza);

        terrenoDeJuego.puedeEdificioVerA(unaPosicionDeLaPlaza, posicionDeCreacion);

        Aldeano aldeanoCreado = plazaCentral.crearAldeano();
/*
        Posicion posicionAdyacente = terrenoDeJuego.obtenerPosicionAdyacente(posicionDeCreacion);
*/
        poblacion.agregar(posicionDeCreacion,aldeanoCreado);
        terrenoDeJuego.ocupar(posicionDeCreacion,aldeanoCreado);

    }

    public void jugarTurno() {

    }

    public void atacar(Guerrero guerreroAtacante, Unidad unidadAtacada){
        guerreroAtacante.atacar(unidadAtacada);
    }

    public void atacar(Guerrero guerrero, Edificio edificioAAtacar){
        guerrero.atacar(edificioAAtacar);
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
