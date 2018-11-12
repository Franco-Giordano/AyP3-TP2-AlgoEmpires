package algoempires;

import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.unidad.Unidad;

//TODO de momento son regiones de 3x3, despues se puede generalizar para trabajar con edificios o rangos
//TODO region ahora no tiene comportamiento ekisde
public class Region {

    private Parcela[][] parcelasEnRegion;

    public Region(Parcela[][] parcelasRecibidas) {
        this.parcelasEnRegion = parcelasRecibidas;
    }

    public void ocupar(Edificio edificioOcupante) {

        for (int i = 0; i < parcelasEnRegion.length; i++) {
            for (int j = 0; j < parcelasEnRegion[0].length; j++) {
                parcelasEnRegion[i][j].ocupar(edificioOcupante);
            }
        }
    }

    public void ocuparCentro(Unidad unidadOcupante) {

        int centroHorizontal = parcelasEnRegion.length / 2;
        int centroVertical = parcelasEnRegion[0].length / 2;

        parcelasEnRegion[centroHorizontal][centroVertical].ocupar(unidadOcupante);
    }

}
