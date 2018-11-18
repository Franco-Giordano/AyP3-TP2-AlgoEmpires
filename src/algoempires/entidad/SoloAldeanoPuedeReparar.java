package algoempires.entidad;

public class SoloAldeanoPuedeReparar extends RuntimeException {

    public SoloAldeanoPuedeReparar(){
        super(String.format("Se esperaba un aldeano para reparar, pero no se encontró."));
    }
}
