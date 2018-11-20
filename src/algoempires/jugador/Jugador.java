package algoempires.jugador;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.SoloUnidadesSePuedenDesplazarException;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.guerrero.Guerrero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;

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

    //TODO de momento se asume que TODAS las posiciones de entidades recibidas son propietarias de este jugador, habra que chequearlo

    public void moverUnidad(Posicion posicionRecibida, Direccion direccionRecibida) {

        try {
            terrenoDeJuego.moverUnidad(posicionRecibida, direccionRecibida);
        } catch (PosicionInvalidaException | SoloUnidadesSePuedenDesplazarException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }
    }


    public void crearAldeano(Posicion unaPosicionDeLaPlaza, Posicion posicionDeCreacion) {

        PlazaCentral plazaCentral = (PlazaCentral) edificiosPropios.get(unaPosicionDeLaPlaza);

        terrenoDeJuego.puedeEdificioVerA(unaPosicionDeLaPlaza, posicionDeCreacion);


        Aldeano aldeanoCreado = plazaCentral.crearAldeano();

        try {
            aldeanoCreado.cobrar(monedero);

            poblacion.agregar(posicionDeCreacion, aldeanoCreado);
            terrenoDeJuego.ocupar(posicionDeCreacion, aldeanoCreado);
        } catch (OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }

    }


    //TODO esto IGUAL al crearAldeano, ver forma de juntarlos
    public void crearEspadachin(Posicion unaPosicionDelCuartel, Posicion posicionDeCreacion) {

        Cuartel cuartel = (Cuartel) edificiosPropios.get(unaPosicionDelCuartel);

        terrenoDeJuego.puedeEdificioVerA(unaPosicionDelCuartel, posicionDeCreacion);

        Espadachin espadachinCreado = cuartel.crearEspadachin();

        try {
            espadachinCreado.cobrar(monedero);

            poblacion.agregar(posicionDeCreacion, espadachinCreado);
            terrenoDeJuego.ocupar(posicionDeCreacion, espadachinCreado);
        } catch (OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }

    }

    //TODO IDEM
    public void crearArquero(Posicion unaPosicionDelCuartel, Posicion posicionDeCreacion) {

        Cuartel cuartel = (Cuartel) edificiosPropios.get(unaPosicionDelCuartel);

        terrenoDeJuego.puedeEdificioVerA(unaPosicionDelCuartel, posicionDeCreacion);

        Arquero arqueroCreado = cuartel.crearArquero();

        try {
            arqueroCreado.cobrar(monedero);

            poblacion.agregar(posicionDeCreacion, arqueroCreado);
            terrenoDeJuego.ocupar(posicionDeCreacion, arqueroCreado);
        } catch (OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }
    }

    //TODO AAAAAAAAAAAAAAAAAAAAA
    public void crearArmaDeAsedio(Posicion unaPosicionDelCastillo, Posicion posicionDeCreacion) {

        Castillo castillo = (Castillo) edificiosPropios.get(unaPosicionDelCastillo);

        terrenoDeJuego.puedeEdificioVerA(unaPosicionDelCastillo, posicionDeCreacion);

        ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

        try {
            armaDeAsedio.cobrar(monedero);

            poblacion.agregar(posicionDeCreacion, armaDeAsedio);
            terrenoDeJuego.ocupar(posicionDeCreacion, armaDeAsedio);
        } catch (OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }
    }


    public Jugador jugarTurnoYDevolverSiguienteJugador() {

        //El controlador/view ejecuta las elecciones que hace el jugador

        return jugadorContrincante;
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
