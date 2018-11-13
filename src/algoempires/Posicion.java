package algoempires;

import algoempires.direccion.Direccion;
import algoempires.entidad.unidad.Unidad;

public class Posicion {

    private Region areaDeMovimiento;
    private Casillero casilleroQueOcupo;

    public Posicion(Casillero casillero) {
        this.areaDeMovimiento = casillero.generarRegion();
        this.casilleroQueOcupo= casillero;
    }

    public void desplazarHacia(Direccion direccion) throws CasilleroInvalidoException {

        coordenada.mover(direccion);
        areaDeMovimiento = coordenada.generarRegion();
    }

    public boolean estaEn(Coordenada coordenada) {

        return (this.coordenada.getCoordenadaHorizontal() == coordenada.getCoordenadaHorizontal() &&
                this.coordenada.getCoordenadaVertical() == coordenada.getCoordenadaVertical());
    }

    public void ocupar(Unidad unidadOcupante) {
        areaDeMovimiento.ocuparCentro(unidadOcupante);
    }

}
