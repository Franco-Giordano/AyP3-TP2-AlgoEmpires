package algoempires;

import algoempires.direccion.Direccion;
import algoempires.entidad.Entidad;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

import java.util.ArrayList;
import java.util.HashMap;

public class Terreno {

    private HashMap<Casillero, Entidad> mapa;
    private Casillero limiteInfIzq;
    private Casillero limiteSupDer;

    public Terreno(int tamanioHorizontal, int tamanioVertical) throws DimensionesInvalidasError {

        if (tamanioHorizontal <= 0 || tamanioVertical <= 0) {
            throw new DimensionesInvalidasError(tamanioHorizontal, tamanioVertical);
        }

        this.limiteInfIzq = new Casillero(1, 1);
        this.limiteSupDer = new Casillero(tamanioHorizontal, tamanioVertical);

        mapa = new HashMap<>();

        for (int i = 1; i <= tamanioHorizontal; i++) {
            for (int j = 1; j <= tamanioVertical; j++) {

                Casillero casillero = new Casillero(i, j);
                mapa.put(casillero, null);

                if (i == 1 && j == 1) {
                    this.limiteInfIzq = casillero;
                }

                if (i == tamanioHorizontal && j == tamanioVertical) {
                    this.limiteSupDer = casillero;
                }
            }
        }

    }

    public boolean estaOcupada(Casillero casillero) {

        return mapa.get(casillero) != null;

    }

    public void reparar(Casillero casillero) {

        Edificio edificioAReparar = (Edificio) (mapa.get(casillero));

        edificioAReparar.reparar();
    }

    public void moverUnidad(Casillero casilleroRecibido, Direccion direccionRecibida) throws CasilleroInvalidoException {

        Casillero casilleroQueQuieroOcupar = casilleroRecibido.generarMovimientoHacia(direccionRecibida);

        Unidad unidadDesplazada = (Unidad) mapa.get(casilleroRecibido);

        this.ocupar(casilleroQueQuieroOcupar, unidadDesplazada);

        mapa.replace(casilleroRecibido, null);

    }

    private boolean casilleroEnRango(Casillero casillero) {

        return casillero.pertenzcoAlRango(limiteInfIzq, limiteSupDer);
    }


    //METODOS DE TESTEO
    public int getTamHorizontal() {
        return limiteSupDer.getHorizontal();
    }

    public int getTamVertical() {
        return limiteSupDer.getVertical();
    }


    //TODO chequear casillero valido (no ocupado por ej)
    public void ocupar(Casillero casillero, Entidad entidad) throws CasilleroInvalidoException {

        if (!casilleroEnRango(casillero) || (estaOcupada(casillero))) {
            throw new CasilleroInvalidoException(casillero);
        }

        mapa.put(casillero, entidad);
    }

    public void ocupar(Region region, Edificio edificio) throws CasilleroInvalidoException {

        ArrayList<Casillero> casillerosAOcupar = region.generarCasillerosContenidos();

        for (Casillero each : casillerosAOcupar) {
            this.ocupar(each, edificio);
        }
    }

    //METODO UNIAMENTE DE TESTEO
    public HashMap<Casillero, Entidad> getMapa() {
        return this.mapa;
    }

}

