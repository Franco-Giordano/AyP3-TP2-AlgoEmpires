package algoempires;

import algoempires.direccion.DireccionAbajoDerecha;
import algoempires.direccion.DireccionArribaIzquierda;

public class Terreno {

    private Parcela[][] parcelas;
    private int tamVertical;
    private int tamHorizontal;

    public Terreno(int tamanioVertical, int tamanioHorizontal) {

        this.tamHorizontal = tamanioHorizontal;
        this.tamVertical = tamanioVertical;

        parcelas = new Parcela[tamanioVertical][tamanioHorizontal];

        for (int i = 0; i < tamanioVertical; i++) {
            for (int j = 0; j < tamanioHorizontal; j++) {
                Parcela parcela = new Parcela();
                parcelas[i][j] = parcela;
            }
        }

    }

    public boolean estaOcupada(int coordenadaVertical, int coordenadaHorizontal) {

        return parcelas[coordenadaVertical][coordenadaHorizontal].estaOcupada();

    }

    public Region obtenerAdyacentesA(Coordenada coordenada){

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

        this.tamVertical = parcelasEnRegion.length;
        for (int i = 0; i < this.tamVertical; i++) {
            this.tamHorizontal = parcelasEnRegion[0].length;
            for (int j = 0; j < this.tamHorizontal; j++) {

                parcelasEnRegion[i][j] = this.parcelas[i + corrimientoVertical][j + corrimientoHorizontal];

            }
        }

        return new Region(parcelasEnRegion);
    }


    public void esMovimientoValido(int posVertical, int posHorizontal) throws MovimientoInvalidoException {

        boolean estaEnRangoVertical = 0 <= posVertical && posVertical < tamVertical;
        boolean estaEnRangoHorizontal = 0 <= posHorizontal && posHorizontal < tamHorizontal;

        if (!estaEnRangoHorizontal || !estaEnRangoVertical || parcelas[posVertical][posHorizontal].estaOcupada()){
            throw new MovimientoInvalidoException(posVertical, posHorizontal);
        }

    }


    //METODOS DE TESTEO
    public int getTamHorizontal() {
        return tamHorizontal;
    }

    public int getTamVertical() {
        return tamVertical;
    }
}
