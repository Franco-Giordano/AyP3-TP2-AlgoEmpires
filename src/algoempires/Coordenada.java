package algoempires;

import algoempires.direccion.Direccion;

public class Coordenada {

    private int coordenadaVertical;

    private int coordenadaHorizontal;

    private Terreno terreno;


    public Coordenada(int coordenadaVertical, int coordenadaHorizontal, Terreno terreno) {

        this.coordenadaVertical = coordenadaVertical;
        this.coordenadaHorizontal = coordenadaHorizontal;

        this.terreno = terreno;

    }

    public void mover(Direccion direccion) {

        this.coordenadaVertical += direccion.getVertical();
        this.coordenadaHorizontal += direccion.getHorizontal();

    }

    public Coordenada generarMovidaHacia(Direccion direccion) {
        return new Coordenada(coordenadaVertical + direccion.getVertical(),
                coordenadaHorizontal + direccion.getHorizontal(), terreno);
    }

    public int getCoordenadaHorizontal() {
        return this.coordenadaHorizontal;
    }

    public int getCoordenadaVertical() {
        return this.coordenadaVertical;
    }

    public Region generarRegion() {

        return terreno.obtenerAdyacentesA(this);

    }
}
