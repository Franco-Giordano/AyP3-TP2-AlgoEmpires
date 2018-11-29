package algoempires.jugador;

import algoempires.entidad.Atacante;
import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Arquero;
import algoempires.entidad.unidad.guerrero.Espadachin;
import algoempires.entidad.unidad.guerrero.armadeasedio.ArmaDeAsedio;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.excepciones.*;
import algoempires.tablero.Posicion;
import algoempires.tablero.Terreno;
import algoempires.tablero.direccion.Direccion;

import java.util.ArrayList;
import java.util.HashSet;

public class Jugador {

    private String nombre;
    private Poblacion poblacion;
    private HashSet<Edificio> edificiosPropios;
    private Terreno terrenoDeJuego;
    private Monedero monedero;

    public Jugador(String nombreRecibido, Terreno terrenoDeJuego) {
        this.nombre= nombreRecibido;
        this.poblacion = new Poblacion();
        this.edificiosPropios = new HashSet<>();
        this.terrenoDeJuego = terrenoDeJuego;
        this.monedero = new Monedero();
    }

    //TODO de momento se asume que TODAS las posiciones de entidades recibidas son propietarias de este jugador, habra que chequearlo

    public void moverUnidad(Posicion posicionRecibida, Direccion direccionRecibida) {

        try {
            terrenoDeJuego.moverUnidad(posicionRecibida, direccionRecibida);
        } catch (PosicionInvalidaException | SoloUnidadesSePuedenDesplazarException | UnidadNoPuedeMoverseException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }
    }

    //TODO buscar manera (si la hay) de hacer un metodo general de crear unidades.
    public void crearAldeano(PlazaCentral plazaCentral, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(plazaCentral, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Aldeano aldeanoCreado = plazaCentral.crearAldeano();

            terrenoDeJuego.ocupar(posicionDeCreacion, aldeanoCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }

    }

    public void crearEspadachin(Cuartel cuartel, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(cuartel, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Espadachin espadachinCreado = cuartel.crearEspadachin();

            terrenoDeJuego.ocupar(posicionDeCreacion, espadachinCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }

    }

    public void crearArquero(Cuartel cuartel, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(cuartel, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {

            Arquero arqueroCreado = cuartel.crearArquero();

            terrenoDeJuego.ocupar(posicionDeCreacion, arqueroCreado);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }
    }

    public void crearArmaDeAsedio(Castillo castillo, Posicion posicionDeCreacion) {

        if (!terrenoDeJuego.puedeEdificioVerA(castillo, posicionDeCreacion)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {
            ArmaDeAsedio armaDeAsedio = castillo.crearArmaDeAsedio();

            terrenoDeJuego.ocupar(posicionDeCreacion, armaDeAsedio);
        } catch (SeIntentoSuperarPoblacionMaximaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }
    }

    public void reparar(Aldeano aldeano, Posicion posAReparar) {

        try {

            Edificio edificio = (Edificio) terrenoDeJuego.obtenerEntidadEnPosicion(posAReparar);

            aldeano.ordenarReparacion(edificio);

        } catch (SoloUnAldeanoReparaALaVezException e) {

            e.printStackTrace();
        }
    }

    public void crearPlazaCentral(Aldeano aldeano, Posicion posAConstruir) {

        PlazaCentral plazaCentral= new PlazaCentral();
        ArrayList<Posicion> posiciones= plazaCentral.calcularPosicionesAOcupar(posAConstruir);

        if (!terrenoDeJuego.puedeUnidadVerA(aldeano, posiciones)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {
            PlazaCentral plaza = aldeano.construirPlazaCentral();

            terrenoDeJuego.ocupar(posAConstruir, plaza);

        } catch (PosicionInvalidaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }

    }

    public void crearCuartel(Aldeano aldeano, Posicion posAConstruir) {

        Cuartel cuartelGenerico= new Cuartel();
        ArrayList<Posicion> posiciones= cuartelGenerico.calcularPosicionesAOcupar(posAConstruir);

        if (!terrenoDeJuego.puedeUnidadVerA(aldeano, posiciones)) {
            throw new PosicionDeCreacionFueraDeRangoException();
        }

        try {
            Cuartel cuartel = aldeano.construirCuartel();

            terrenoDeJuego.ocupar(posAConstruir, cuartel);

        } catch (PosicionInvalidaException | OroInsuficienteException e) {
            //TODO Avisar que fallo la operacion mediante el VistaPartidaController
        }

    }

    public void jugarTurno() {

        //El controlador/view ejecuta las elecciones que hace el jugador

        this.actualizarEntreTurnos();

    }

    public void actualizarEntreTurnos() {
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

    public void agregar(Edificio edificio) {
        edificiosPropios.add(edificio);
    }

    public void agregar(Unidad unidad) {
        poblacion.agregar(unidad);
    }

    public void cobrar(int costo) {
        this.monedero.restarOro(costo);
    }

    public void quitarDePoblacion(Unidad unidad) {
        poblacion.quitar(unidad);
    }

    public HashSet<Entidad> calcularCercanosA(Castillo castillo) {
        return terrenoDeJuego.calcularCercanosA(castillo);
    }

    public void posicionarLaEntidad(Posicion posicion, Edificio entidad) {
        terrenoDeJuego.ocupar(posicion, entidad);
    }

    public void posicionarLaEntidad(Posicion posicion, Unidad entidad) {
        terrenoDeJuego.ocupar(posicion, entidad);
    }

    //METODO DE TESTEO
    public String getNombre() {
        return nombre;
    }

    public int getOro() {
        return monedero.getOro();
    }

    public boolean tieneCastilloEn(Posicion posicion) {
        return terrenoDeJuego.obtenerEntidadEnPosicion(posicion).getClass() == Castillo.class;
    }

    public boolean tienePlazaCentralEn(Posicion posicion) {
        return terrenoDeJuego.obtenerEntidadEnPosicion(posicion).getClass() == PlazaCentral.class;
    }

    public boolean tieneAldeanoEn(Posicion posicion) {
        return terrenoDeJuego.obtenerEntidadEnPosicion(posicion).getClass() == Aldeano.class;
    }

    public boolean tieneEstaCantidadDePropiedades(int cantPobladores, int cantEdificios) {
        return poblacion.getCantidadDeHabitantes() == cantPobladores && edificiosPropios.size() == cantEdificios;
    }

    public int getCantidadDeHabitantes(){
        return poblacion.getCantidadDeHabitantes();
    }


}
