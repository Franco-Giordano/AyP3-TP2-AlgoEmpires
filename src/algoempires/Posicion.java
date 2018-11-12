package algoempires;

import algoempires.direccion.Direccion;

public class Posicion {

    private Region areaDeMovimiento;
    private Coordenada coordenada;

    public Posicion(Coordenada coordenadaActual) {
        this.areaDeMovimiento = coordenadaActual.generarRegion();
        this.coordenada = coordenadaActual;
    }

    public void desplazarHacia(Direccion direccion) {
        coordenada.mover(direccion);
        areaDeMovimiento = coordenada.generarRegion();
    }

    public boolean estaEn(Coordenada coordenada) {

        return (this.coordenada.getCoordenadaHorizontal() == coordenada.getCoordenadaHorizontal() &&
                this.coordenada.getCoordenadaVertical() == coordenada.getCoordenadaVertical());
    }

}
