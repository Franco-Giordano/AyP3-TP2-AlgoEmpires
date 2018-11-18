package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;
import algoempires.tablero.direccion.Direccion;

import java.util.ArrayList;
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

    public void moverUnidad(Posicion posicionRecibida, Direccion direccionRecibida) throws CasilleroInvalidoException {

        Posicion posicionQueQuieroOcupar = posicionRecibida.generarMovimientoHacia(direccionRecibida);

        Casillero casilleroOcupadoActualmente = mapa.get(posicionRecibida);

        Casillero casilleroQueQuieroOcupar = mapa.get(posicionQueQuieroOcupar);

        casilleroOcupadoActualmente.trasladarUnidadA(casilleroQueQuieroOcupar);

    }

    private boolean posicionEnRango(Posicion posicion) {

        return posicion.pertenzcoAlRango(limiteInfIzq, limiteSupDer);
    }


    //METODOS DE TESTEO
    public int getTamHorizontal() {
        return limiteSupDer.getHorizontal();
    }

    public int getTamVertical() {
        return limiteSupDer.getVertical();
    }


    public void ocupar(Posicion posicion, Entidad entidad) throws CasilleroInvalidoException {

        if (!posicionEnRango(posicion) || (estaOcupada(posicion))) {
            throw new CasilleroInvalidoException();
        }

        mapa.get(posicion).ocupar(entidad);
    }

    public void ocupar(Region region, Edificio edificio) throws CasilleroInvalidoException {

        ArrayList<Posicion> casillerosAOcupar = region.generarCasillerosContenidos();

        for (Posicion each : casillerosAOcupar) {
            this.ocupar(each, edificio);
        }
    }

    //METODO UNIAMENTE DE TESTEO
    public boolean compararVidaDe(Posicion posicionAConstruir, int vidaAComparar) {
        return mapa.get(posicionAConstruir).tieneEstaVida(vidaAComparar);

    }
}

