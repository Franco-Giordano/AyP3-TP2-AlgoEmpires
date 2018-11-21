package algoempires.entidad.unidad.utilero;

public abstract class Estado {

    protected Aldeano aldeano;

    public Estado(Aldeano aldeano){
        this.aldeano = aldeano;
    }

    protected abstract Estado actualizarEntreTurnos();

}
