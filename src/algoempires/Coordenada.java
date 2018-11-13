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

    public static int distanciaVertical(Coordenada coordenadaA, Coordenada coordenadaB) {
        return Math.abs(coordenadaB.coordenadaVertical - coordenadaA.coordenadaVertical);
    }

    public static int distanciaHorizontal(Coordenada coordenadaA, Coordenada coordenadaB) {
        return Math.abs(coordenadaB.coordenadaHorizontal - coordenadaA.coordenadaHorizontal);
    }

    public void mover(Direccion direccion) throws CasilleroInvalidoException {

        this.esDireccionValida(direccion);

        this.coordenadaVertical += direccion.getVertical();
        this.coordenadaHorizontal += direccion.getHorizontal();

    }

    private void esDireccionValida(Direccion direccion) throws CasilleroInvalidoException {

        Coordenada nuevaCoordenada = this.generarMovimientoHacia(direccion);

        terreno.esCasilleroValido(nuevaCoordenada.coordenadaVertical, nuevaCoordenada.coordenadaHorizontal);
    }

    public Coordenada generarMovimientoHacia(Direccion direccion) {
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
