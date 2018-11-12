package algoempires;

import algoempires.direccion.DireccionArribaIzquierda;

public class Terreno {

    private Parcela[][] parcelas;

    public Terreno(int tamanioVertical, int tamanioHorizontal) {

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

        Parcela[][] adyacentes = new Parcela[3][3];

        Coordenada coordenadaSuperiorIzquierda = coordenada.generarMovidaHacia(new DireccionArribaIzquierda());

        int corrimientoVertical = coordenadaSuperiorIzquierda.getCoordenadaVertical();

        int corrimientoHorizontal = coordenadaSuperiorIzquierda.getCoordenadaHorizontal();

        for (int i = 0; i < adyacentes.length; i++) {
            for (int j = 0; j < adyacentes[0].length; j++) {

                adyacentes[i][j] = this.parcelas[i + corrimientoVertical][j + corrimientoHorizontal];

            }
        }

        return new Region(adyacentes);

    }
}
