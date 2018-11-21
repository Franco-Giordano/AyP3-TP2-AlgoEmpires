package algoempires.jugador;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.entidad.EntidadFueraDeRangoException;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.SoloUnidadesSePuedenDesplazarException;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.ArmaDeAsedio;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.Posicion;
import algoempires.tablero.PosicionInvalidaException;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;

import java.util.HashSet;

public class Jugador {

    private Poblacion poblacion;
    private HashSet<Edificio> edificiosPropios;
    private Terreno terrenoDeJuego;
    //private Posicion posicionSeleccionada; // en teoría esto va a servir cuando implementemos la interfaz.
    private Jugador jugadorContrincante;
    private Monedero monedero;

    public Jugador(Terreno terrenoDeJuego) {
        this.poblacion = new Poblacion();
        this.edificiosPropios = new HashSet<>();
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

    public void crearAldeano(PlazaCentral plazaCentral, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(plazaCentral, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Aldeano aldeanoCreado = plazaCentral.crearAldeano();

            terrenoDeJuego.ocupar(posicionDeCreacion, aldeanoCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }

    }

    //TODO esto IGUAL al crearAldeano, ver forma de juntarlos
    public void crearEspadachin(Cuartel cuartel, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(cuartel, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Espadachin espadachinCreado = cuartel.crearEspadachin();

            terrenoDeJuego.ocupar(posicionDeCreacion, espadachinCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }

    }

    //TODO IDEM
    public void crearArquero(Cuartel cuartel, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(cuartel, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Arquero arqueroCreado = cuartel.crearArquero();

            terrenoDeJuego.ocupar(posicionDeCreacion, arqueroCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }
    }

    //TODO AAAAAAAAAAAAAAAAAAAAA
    public void crearArmaDeAsedio(Castillo castillo, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(castillo, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {
            ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

            terrenoDeJuego.ocupar(posicionDeCreacion, armaDeAsedio);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el Controlador
        }
    }

    public Jugador jugarTurnoYDevolverSiguienteJugador() {

        //El controlador/view ejecuta las elecciones que hace el jugador

        this.actualizarEntreTurnos();

        return jugadorContrincante;
    }

    private void actualizarEntreTurnos() {
        poblacion.actualizarUnidades();
        edificiosPropios.forEach((e) -> e.actualizarEntreTurnos());
    }

    public void atacar(Atacante atacante, Posicion posicionDeLaVictima) {

        if (!atacante.puedeVerA(terrenoDeJuego, posicionDeLaVictima)) {
            throw new EntidadFueraDeRangoException();
        }

        terrenoDeJuego.obtenerEntidadEnPosicion(posicionDeLaVictima).recibirAtaqueDe(atacante);
    }

    public void sumarOro(int oro) {
        monedero.sumarOro(oro);
    }

    public void informarDestruccion(Edificio entidad) {

        edificiosPropios.remove(entidad);

        terrenoDeJuego.remover(entidad);
    }

    public void informarDestruccion(Unidad entidad) {

        poblacion.quitar(entidad);

        terrenoDeJuego.remover(entidad);
    }

    public void agregar(Edificio edificio) {
        edificiosPropios.add(edificio);
    }

    public void agregar(Unidad unidad) {
        poblacion.agregar(unidad);
    }

    public void cobrar(int costo) {
        this.monedero.restarOro(costo);
    }

    //METODO DE TESTEO
    public int getOro() {
        return monedero.getOro();
    }


    public HashSet<Entidad> calcularCercanosA(Castillo castillo) {
        return terrenoDeJuego.calcularCercanosA(castillo);
    }
}
