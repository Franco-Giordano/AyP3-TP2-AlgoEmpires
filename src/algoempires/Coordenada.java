package algoempires;

import algoempires.direccion.Direccion;

public class Coordenada {

    private int coordenadaHorizontal;

    private int coordenadaVertical;

    private Terreno terreno;


    public Coordenada(int coordenadaHorizontal, int coordenadaVertical, Terreno terreno) {

        this.coordenadaHorizontal = coordenadaHorizontal;

        this.coordenadaVertical = coordenadaVertical;

        this.terreno = terreno;

    }

    public void mover(Direccion direccion){

        this.coordenadaHorizontal += direccion.getHorizontal();
        this.coordenadaVertical += direccion.getVertical();

    }

    public int getCoordenadaHorizontal(){
        return this.coordenadaHorizontal;
    }

    public int getCoordenadaVertical(){
        return this.coordenadaVertical;
    }

    public Region generarRegion() {

        return terreno.obtenerAdyacentesA(this);
    }
}
