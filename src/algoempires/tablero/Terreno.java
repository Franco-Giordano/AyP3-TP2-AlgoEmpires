package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.guerrero.Guerrero;
import algoempires.tablero.direccion.Direccion;
import algoempires.tablero.direccion.DireccionAbajo;
import algoempires.tablero.direccion.DireccionAbajoIzquierda;
import algoempires.tablero.direccion.DireccionIzquierda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    private void ocuparConEntidad(Posicion posicion, Entidad entidad) {

        this.posicionEnRango(posicion);

        mapa.get(posicion).ocupar(entidad);

    }

    public void ocupar(Posicion posicion, Unidad unidad) throws PosicionInvalidaException {

        this.ocuparConEntidad(posicion, unidad);
    }

    public void ocupar(Posicion posicionInfIzq, Edificio edificio) throws PosicionInvalidaException {

        ArrayList<Posicion> casillerosAOcupar = edificio.generarRegionAPartirDePosicion(posicionInfIzq).generarPosicionesContenidas();

        for (Posicion each : casillerosAOcupar) {
            this.ocuparConEntidad(each, edificio);
        }
    }

    public Casillero getCasilleroEn(Posicion posicion) {
        return mapa.get(posicion);
    }


    public boolean puedeEdificioVerA(Posicion unaPosicionDelEdificio, Posicion posicionQueQuieroVer) {

        Posicion posInfIzq = this.encontrarInfIzqDeEntidad(unaPosicionDelEdificio);

        Edificio edificio = (Edificio) mapa.get(posInfIzq).getEntidadContenida();

        Region regionOcupada = edificio.generarRegionAPartirDePosicion(posInfIzq);

        return Region.generarRegionCentradaEn(regionOcupada, edificio).contains(posicionQueQuieroVer);

    }

    public boolean puedeUnidadVerA(Posicion posUnidad, Posicion posicionQueQuieroVer) {

        Unidad unidad = (Unidad) mapa.get(posUnidad).getEntidadContenida();

        return Region.generarRegionCentradaEn(posUnidad, unidad).contains(posicionQueQuieroVer);

    }

    private Posicion encontrarInfIzqDeEntidad(Posicion unaPosicionDeLaEntidad) {
        Entidad entidad = mapa.get(unaPosicionDeLaEntidad).getEntidadContenida();

        Posicion posIzq = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionIzquierda());
        Posicion posInf = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionAbajo());
        Posicion posIzqInf = unaPosicionDeLaEntidad.generarMovimientoHacia(new DireccionAbajoIzquierda());

        if (mapa.get(posInf).getEntidadContenida() != entidad && mapa.get(posIzq).getEntidadContenida() != entidad && mapa.get(posIzqInf).getEntidadContenida() != entidad) {
            return unaPosicionDeLaEntidad;
        }

        ArrayList<Posicion> posAFiltrar = new ArrayList<>(Arrays.asList(posInf, posIzq, posIzqInf));
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

    public void atacar(Posicion posicionAtacante, Posicion posicionDelAtacado) {
        Guerrero guerrero = (Guerrero) mapa.get(posicionAtacante).getEntidadContenida();
        Entidad entidad = (Entidad) mapa.get(posicionDelAtacado).getEntidadContenida();
        guerrero.atacar((Unidad) entidad);
    }
}

