package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.SoloAldeanoPuedeReparar;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.utilero.Aldeano;
import algoempires.tablero.direccion.Direccion;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public void informarEdificiosAlAlcance(Posicion posicionRecibida){

        try {
            Aldeano aldeano = (Aldeano) mapa.get(posicionRecibida).entidadContenida;

            ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();

            ArrayList<Posicion> rango = aldeano.generarRangoAPartirDePosicion(posicionRecibida);

            for (Posicion each : rango) {
                if (mapa.get(each).estaOcupada()) {
                    listaEdificios.add((Edificio) mapa.get(each).entidadContenida);
                }
            }

            aldeano.setReparables(listaEdificios);

        }catch (ClassCastException exception){
            throw new SoloAldeanoPuedeReparar();
        }

    }

    public void moverUnidad(Posicion posicionRecibida, Direccion direccionRecibida) throws CasilleroInvalidoException {

        Posicion posicionQueQuieroOcupar = posicionRecibida.generarMovimientoHacia(direccionRecibida);

        Casillero casilleroOcupadoActualmente = mapa.get(posicionRecibida);

        Casillero casilleroQueQuieroOcupar = mapa.get(posicionQueQuieroOcupar);

        casilleroOcupadoActualmente.trasladarUnidadA(casilleroQueQuieroOcupar);

    }

    private boolean posicionEnRango(Posicion posicion) {

        return posicion.pertenzcoAlRango(limiteInfIzq, limiteSupDer);
    }


    private void ocupar(Posicion posicion, Entidad entidad){

        if (!posicionEnRango(posicion) || (estaOcupada(posicion))) {
            throw new CasilleroInvalidoException();
        }

        mapa.get(posicion).ocupar(entidad);

    }

    public void ocuparConUnidad(Posicion posicion, Unidad unidad) throws CasilleroInvalidoException {

        this.ocupar(posicion,unidad);
    }

    public void ocuparConEdificio(Posicion posicion, Edificio edificio) throws CasilleroInvalidoException {

        ArrayList<Posicion> casillerosAOcupar = edificio.generarRegionAPartirDePosicion(posicion).generarPosicionesContenidas();

        for (Posicion each : casillerosAOcupar) {
            this.ocupar(each, edificio);
        }
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

