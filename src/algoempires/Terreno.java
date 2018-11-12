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
    }

    private boolean parEnRango(int posVertical, int posHorizontal) {
        boolean estaEnRangoVertical = 0 <= posVertical && posVertical < tamVertical;
        boolean estaEnRangoHorizontal = 0 <= posHorizontal && posHorizontal < tamHorizontal;

        return estaEnRangoHorizontal && estaEnRangoVertical;
    }


    public void esMovimientoValido(int posVertical, int posHorizontal) throws MovimientoInvalidoException {

        if (!this.parEnRango(posVertical, posHorizontal) || parcelas[posVertical][posHorizontal].estaOcupada()) {
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
