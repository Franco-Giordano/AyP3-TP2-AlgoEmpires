package algoempires;

//TODO de momento son regiones de 3x3, despues se puede generalizar para trabajar con edificios o rangos
public class Region {

    private Parcela[][] parcelasEnRegion;

    public Region(Parcela[][] parcelasRecibidas) {
        this.parcelasEnRegion = parcelasRecibidas;
    }

}
