package algoempires;

import algoempires.entidad.Entidad;

import java.util.HashMap;

public class Terreno {

    private HashMap<Casillero, Entidad> mapa;
    private Casillero limiteInfIzq;
    private Casillero limiteSupDer;

    public Terreno(int tamanioHorizontal, int tamanioVertical) {

        this.limiteInfIzq = new Casillero(1,1);
        this.limiteSupDer = new Casillero(tamanioHorizontal, tamanioVertical);

        mapa = new HashMap<Casillero, Entidad>();

        for (int i = 1; i <= tamanioHorizontal; i++) {
            for (int j = 1; j <= tamanioVertical; j++) {

                Casillero casillero = new Casillero(i,j);
                mapa.put(casillero, null);

                if (i == 1 && j== 1) {
                    this.limiteInfIzq = casillero;
                }

                if (i == tamanioHorizontal && j== tamanioVertical) {
                    this.limiteSupDer = casillero;
                }
            }
        }

    }

    public boolean estaOcupada(Casillero casillero) {

        return mapa.get(casillero) != null;

    }

    /*

    public Region obtenerAdyacentesA(Coordenada coordenada) {

        Coordenada coordSuperiorIzquierda = coordenada.generarMovimientoHacia(new DireccionArribaIzquierda());

        Coordenada coordInferiorDerecha = coordenada.generarMovimientoHacia(new DireccionAbajoDerecha());

        return obtenerRegionDelimitadaPor(coordSuperiorIzquierda, coordInferiorDerecha);

    }

    public Region obtenerRegionDelimitadaPor(Coordenada coordenadaSupIzq, Coordenada coordenadaInfDer) {

        int tamVertical = Coordenada.distanciaVertical(coordenadaSupIzq, coordenadaInfDer) + 1;
        int tamHorizontal = Coordenada.distanciaHorizontal(coordenadaSupIzq, coordenadaInfDer) + 1;

        Parcela[][] parcelasEnRegion = new Parcela[tamVertical][tamHorizontal];

        int corrimientoVertical = coordenadaSupIzq.getCoordenadaVertical();

        int corrimientoHorizontal = coordenadaSupIzq.getCoordenadaHorizontal();

        for (int i = 0; i < tamVertical; i++) {
            for (int j = 0; j < tamHorizontal; j++) {

                if (this.parEnRango(i + corrimientoVertical, j + corrimientoHorizontal)) {
                    parcelasEnRegion[i][j] = this.parcelas[i + corrimientoVertical][j + corrimientoHorizontal];
                }
            }
        }

        return new Region(parcelasEnRegion);
    } */

    private boolean casilleroEnRango(Casillero casillero) {

        return casillero.pertenzcoAlRango(limiteInfIzq, limiteSupDer);
    }


    public void esCasilleroValido(Casillero casillero) throws CasilleroInvalidoException {

        if (!this.casilleroEnRango(casillero) || this.estaOcupada(casillero)) {
            throw new CasilleroInvalidoException(casillero);
        }

    }


    //METODOS DE TESTEO
    public int getTamHorizontal() {
        return limiteSupDer.getHorizontal();
    }

    public int getTamVertical() {
        return limiteSupDer.getVertical();
    }
}
