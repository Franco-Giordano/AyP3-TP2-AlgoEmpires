package algoempires.direccion;

public abstract class Direccion {

    protected int direccionHorizontal;

    protected int direccionVertical;

    public int getHorizontal () {
        return this.direccionHorizontal;
    }

    public int getVertical(){
        return this.direccionVertical;
    }
}
