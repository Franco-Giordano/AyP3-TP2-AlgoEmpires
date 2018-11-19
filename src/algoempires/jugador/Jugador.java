package algoempires.jugador;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;

import java.util.ArrayList;

public class Jugador {

    private Poblacion poblacion;
    private ArrayList<Edificio> edificiosPropios;
    private Terreno terrenoDeJuego;
    private Jugador jugadorContrincante;
    private Monedero monedero;

    public Jugador(Terreno terrenoDeJuego) {
        this.poblacion= new Poblacion();
        this.edificiosPropios = new ArrayList<>();
        this.terrenoDeJuego = terrenoDeJuego;
        this.monedero = new Monedero();
    }

    public void setContrincante(Jugador jugador) {
        jugadorContrincante = jugador;
    }

    //TODO obtener posicion adyacente
    public void crearAldeano(Posicion posicion, Posicion posicionAdyacente){

      //  PlazaCentral plazaCentral = edificiosPropios.buscar(terrenoDeJuego.obtener(posicion));
        Aldeano aldeanoCreado = terrenoDeJuego.crearAldeanoDesdePosicion(posicion);
        poblacion.agregar(aldeanoCreado);
      //  Posicion posicionAdyancente = generarAdyancente(posicion);
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

    public void asignarAlJugador(Entidad entidad) {
        edificiosPropios.add(entidad);
    }
}
