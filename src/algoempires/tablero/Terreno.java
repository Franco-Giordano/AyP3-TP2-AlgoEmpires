package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.SoloAldeanoPuedeReparar;
import algoempires.entidad.SoloUnidadesPuedenVerASuAlrededorException;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Guerrero;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.direccion.Direccion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Terreno {

    private HashMap<Posicion, Casillero> mapa;
    private Posicion limiteInfIzq;
    private Posicion limiteSupDer;

    public Terreno(int tamanioHorizontal, int tamanioVertical) throws DimensionesInvalidasError {

        if (tamanioHorizontal <= 0 || tamanioVertical <= 0) {
            throw new DimensionesInvalidasError(tamanioHorizontal, tamanioVertical);
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

    public void reparar(Posicion posicion) {

        informarEdificiosAlAlcance(posicion);

        mapa.get(posicion).reparar();
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

    private void ocuparConEntidad(Posicion posicion, Entidad entidad){

        this.posicionEnRango(posicion);

        mapa.get(posicion).ocupar(entidad);

    }

    public void ocupar(Posicion posicion, Unidad unidad) throws PosicionInvalidaException {

        this.ocuparConEntidad(posicion,unidad);
    }

    public void ocupar(Posicion posicion, Edificio edificio) throws PosicionInvalidaException {

        ArrayList<Posicion> casillerosAOcupar = edificio.generarRegionAPartirDePosicion(posicion).generarPosicionesContenidas();

        for (Posicion each : casillerosAOcupar) {
            this.ocuparConEntidad(each, edificio);
        }
    }

    public void informarEntidadesAlAlcance(Posicion posicionRecibida) {

        try {

            Guerrero unidad = (Guerrero) mapa.get(posicionRecibida).getEntidadContenida();

            HashSet<Entidad> listaEntidades = new HashSet<>();

            ArrayList<Posicion> rango = unidad.generarRangoAPartirDePosicion(posicionRecibida);

            for (Posicion each : rango) {
                if (mapa.get(each).estaOcupada()) {
                    listaEntidades.add(mapa.get(each).getEntidadContenida());
                }
            }

            if (!rango.isEmpty()) {
                unidad.setAtacables(listaEntidades);
            }

        }catch (ClassCastException exception){
            throw new SoloUnidadesPuedenVerASuAlrededorException();
        }

    }

    //TODO probablemente este metodo se pueda obviar, si lo manejamos bien, le informamos tanto las que puede atacarA como las
    //que puede reparar al aldeano, y lesto.

    public void informarEdificiosAlAlcance(Posicion posicionRecibida){

        try {
            Aldeano aldeano = (Aldeano) mapa.get(posicionRecibida).getEntidadContenida();

            HashSet<Edificio> listaEdificios = new HashSet<>();

            ArrayList<Posicion> rango = aldeano.generarRangoAPartirDePosicion(posicionRecibida);

            for (Posicion each : rango) {
                if (mapa.get(each).estaOcupada()) {
                    listaEdificios.add((Edificio) mapa.get(each).getEntidadContenida());
                }
            }

            aldeano.setReparables(listaEdificios);

        }catch (ClassCastException exception){
            throw new SoloAldeanoPuedeReparar();
        }

    }

    public Casillero getCasilleroEn(Posicion posicion){
        return mapa.get(posicion);
    }

    //METODOS DE TESTEO
    public boolean compararVidaDe(Posicion posicionAConstruir, int vidaAComparar) {
        return mapa.get(posicionAConstruir).tieneEstaVida(vidaAComparar);

    }

    public int getTamHorizontal() {
        return limiteSupDer.getHorizontal();
    }

    public int getTamVertical() {
        return limiteSupDer.getVertical();
    }






}

