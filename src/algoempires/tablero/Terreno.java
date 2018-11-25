package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Castillo;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.excepciones.DimensionesInvalidasException;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.tablero.direccion.Direccion;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionAbajoIzquierda;
import algoempires.tablero.direccion.DireccionIzquierda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Terreno {

    private HashMap<Posicion, Casillero> mapa;
    private Posicion limiteInfIzq;
    private Posicion limiteSupDer;

    public Terreno(int tamanioHorizontal, int tamanioVertical) throws DimensionesInvalidasException {

        if (tamanioHorizontal <= 0 || tamanioVertical <= 0) {
            throw new DimensionesInvalidasException(tamanioHorizontal, tamanioVertical);
        }

        this.limiteInfIzq = new Posicion(1, 1);
        this.limiteSupDer = new Posicion(tamanioHorizontal, tamanioVertical);

        mapa = new HashMap<Posicion, Casillero>();

        for (int i = 1; i <= tamanioHorizontal; i++) {
            for (int j = 1; j <= tamanioVertical; j++) {

                Posicion posicion = new Posicion(i, j);
                Casillero casillero = new Casillero(posicion);
                mapa.put(posicion, casillero);

                if (i == 1 && j == 1) {
                    this.limiteInfIzq = posicion;
                }

                if (i == tamanioHorizontal && j == tamanioVertical) {
                    this.limiteSupDer = posicion;
                }
            }
        }

    }

    public boolean estaOcupada(Posicion posicion) {

        return mapa.get(posicion).estaOcupada();

    }

    public void moverUnidad(Posicion posicionRecibida, Direccion direccionRecibida) throws PosicionInvalidaException {

        Posicion posicionQueQuieroOcupar = posicionRecibida.generarMovimientoHacia(direccionRecibida);

        this.posicionEnRango(posicionQueQuieroOcupar);

        Casillero casilleroOcupadoActualmente = mapa.get(posicionRecibida);

        Casillero casilleroQueQuieroOcupar = mapa.get(posicionQueQuieroOcupar);

        casilleroOcupadoActualmente.trasladarUnidadA(casilleroQueQuieroOcupar);
    }

    private void posicionEnRango(Posicion posicion) {

        if (!mapa.containsKey(posicion)) {
            throw new PosicionInvalidaException("La posicion no esta en rango");
        }
    }

    private boolean contienePosicion(Posicion posicion) {
        return mapa.containsKey(posicion);
    }

    private void ocuparConEntidad(Posicion posicion, Entidad entidad) {

        this.posicionEnRango(posicion);

        mapa.get(posicion).ocupar(entidad);

    }

    public void ocupar(Posicion posicion, Unidad unidad) throws PosicionInvalidaException {

        this.ocuparConEntidad(posicion, unidad);

        unidad.informarDeCasilleroOcupado(this.mapa.get(posicion));
    }

    public void ocupar(Posicion posicionInfIzq, Edificio edificio) throws PosicionInvalidaException {

        Region region = edificio.generarRegion(this.generarCasillerosOcupadosPor(edificio, posicionInfIzq));

        ArrayList <Posicion> posiciones = generarPosicionesContenidas(edificio,posicionInfIzq);

        edificio.informarRegionOcupada(region);
    }


    public boolean puedeEdificioVerA(Edificio edificio, Posicion posicionQueQuieroVer) {
        return Rango.generarPosicionesVisiblesPor(edificio.getRegionQueLoContiene(), edificio).contains(posicionQueQuieroVer);

    }

    public Posicion encontrarUnaPosDeEntidad(Entidad entidad) {

        for (HashMap.Entry<Posicion, Casillero> entry : mapa.entrySet()) {
            Posicion posicion = entry.getKey();
            Casillero casillero = entry.getValue();

            if (casillero.contieneA(entidad)) {
                return posicion;
            }
        }

        return null;
    }

    public boolean puedeUnidadVerA(Unidad unidad, Posicion posicionQueQuieroVer) {

        Posicion posicionUnidad = this.encontrarUnaPosDeEntidad(unidad);

        return Rango.generarPosicionesVisiblesPor(posicionUnidad, unidad).contains(posicionQueQuieroVer);

    }

    private Posicion encontrarInfIzqDeEntidad(Posicion unaPosicionDeLaEntidad) {

        Entidad entidad = mapa.get(unaPosicionDeLaEntidad).getEntidadContenida();

        Posicion posIzq = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionIzquierda());
        Posicion posInf = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionAbajo());
        Posicion posIzqInf = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionAbajoIzquierda());

        ArrayList<Posicion> posAFiltrar = new ArrayList<>(Arrays.asList(posInf, posIzq, posIzqInf));

        posAFiltrar.removeIf(posicion -> !this.contienePosicion(posicion));

        if (posAFiltrar.stream().allMatch(posicion -> mapa.get(posicion).getEntidadContenida() != entidad)) {
            return unaPosicionDeLaEntidad;
        }

        ArrayList<Posicion> posConEntidad = filtrarPosicionesConEntidad(posAFiltrar, entidad);

        return encontrarInfIzqDeEntidad(this.seleccionarMenorModulo(posConEntidad));

    }

    private Posicion seleccionarMenorModulo(ArrayList<Posicion> posConEntidad) {

        Posicion posSeleccionada = posConEntidad.get(0);

        for (Posicion each : posConEntidad) {
            if (each.getModulo() <= posSeleccionada.getModulo()) {
                posSeleccionada = each;
            }
        }

        return posSeleccionada;
    }

    private ArrayList<Posicion> filtrarPosicionesConEntidad(ArrayList<Posicion> posiciones, Entidad entidad) {

        ArrayList<Posicion> resultado = new ArrayList<>();

        for (Posicion each : posiciones) {
            if (mapa.get(each).getEntidadContenida() == entidad) {
                resultado.add(each);
            }
        }

        return resultado;
    }

    public HashSet<Entidad> calcularCercanosA(Castillo castillo) {

        HashSet<Entidad> listaEntidades = new HashSet<>();

        ArrayList<Posicion> rango = Rango.generarPosicionesVisiblesPor(castillo.getRegionQueLoContiene(), castillo);
        rango.removeIf(pos -> !this.contienePosicion(pos));

        for (Posicion posActual : rango) {
            Entidad entidadActual = mapa.get(posActual).getEntidadContenida();
            if (mapa.get(posActual).estaOcupada() && !entidadActual.esDelEquipo(castillo)) {
                listaEntidades.add(entidadActual);
            }
        }

        return listaEntidades;
    }

    public void remover(Entidad entidad) {

        mapa.forEach((k, v) -> {
            if (v.contieneA(entidad)) {
                v.desocupar();
            }
        });
    }

    public Posicion encontrarInfIzq(Castillo castillo) {
        return this.encontrarInfIzqDeEntidad(this.encontrarUnaPosDeEntidad(castillo));
    }

    public ArrayList<Posicion> generarPosicionesContenidas(Edificio edificio, Posicion infIzquierdo) throws PosicionInvalidaException{

        int tamanioHorizontal= edificio.getTamanioHorizontal();

        int tamanioVertical= edificio.getTamanioVertical();

        ArrayList<Posicion> posicionesContenidas = new ArrayList<>();

        for (int i = 0; i < tamanioHorizontal; i++) {
            for (int j = 0; j < tamanioVertical; j++) {
                Posicion posicionContenido = new Posicion(i + infIzquierdo.getHorizontal(),
                        j + infIzquierdo.getVertical());
                posicionEnRango(posicionContenido);
                posicionesContenidas.add(posicionContenido);

            }
        }

        return posicionesContenidas;
    }

    public ArrayList<Casillero> generarCasillerosOcupadosPor(Edificio edificio, Posicion posicion) {

        ArrayList<Posicion> posicionesContenidas = this.generarPosicionesContenidas(edificio, posicion);

        ArrayList<Casillero> casillerosContenidos = new ArrayList<>();

        for (Posicion posActual : posicionesContenidas){
            casillerosContenidos.add(this.mapa.get(posActual));
        }

        return casillerosContenidos;
    }

    //METODOS DE TESTEO

    public int getTamHorizontal() {
        return limiteSupDer.getHorizontal();
    }

    public int getTamVertical() {
        return limiteSupDer.getVertical();
    }

    public Entidad obtenerEntidadEnPosicion(Posicion posicion) {

        return mapa.get(posicion).getEntidadContenida();

    }

    public int getVida(Posicion posicion) {
        return mapa.get(posicion).getEntidadContenida().getVida();
    }

}

