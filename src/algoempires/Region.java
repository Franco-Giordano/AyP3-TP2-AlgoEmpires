package algoempires;


import java.util.HashMap;

//TODO de momento son regiones de 3x3, despues se puede generalizar para trabajar con edificios o rangos
public class Region {

    private Parcela[][] parcelasEnRegion;
    private int tamVertical, tamHorizontal;

    public Region(Parcela[][] parcelasRecibidas) {
        this.parcelasEnRegion = parcelasRecibidas;
        this.tamHorizontal = parcelasRecibidas[0].length;
        this.tamVertical = parcelasRecibidas.length;
    }

    public Parcela getParcelaCentral() {
        return this.parcelasEnRegion[1][1];
    };

    public HashMap<String, Parcela> calcularMapaAdyacentes(String[] direcciones) {

        HashMap<String, Parcela> parcelasAdyacentes = new HashMap<String,Parcela>();

        for (int i = 0; i < tamVertical; i++) {
            for (int j = 0; j < tamHorizontal; j++) {

                if (i!=j) {
                    parcelasAdyacentes.put(direcciones[i*tamVertical + j], parcelasEnRegion[i][j]);
                }
            }
        }

        return parcelasAdyacentes;

    }
}
