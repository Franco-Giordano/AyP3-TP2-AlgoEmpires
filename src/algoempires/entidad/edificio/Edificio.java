package algoempires.entidad.edificio;

import algoempires.entidad.Entidad;
import algoempires.tablero.Casillero;
import algoempires.tablero.CasilleroInvalidoException;
import algoempires.tablero.Region;
import algoempires.tablero.Terreno;

public abstract class Edificio extends Entidad {

    private int turnosDeConstruccion;
    private Region regionQueOcupa;

    public Edificio(Terreno terreno, Casillero casilleroInfIzq) throws CasilleroInvalidoException {
        super(terreno);

        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();

        this.regionQueOcupa = new Region(casilleroInfIzq, getTamanioHorizontal(), getTamanioVertical());
        terrenoDeJuego.ocupar(regionQueOcupa, this);
    }

    public void reparar() {
        this.vida += getVelocidadDeReparacion();
    }

    protected abstract int getTamanioHorizontal();

    protected abstract int getTamanioVertical();

    protected abstract int getTurnosDeContruccionIniciales();

    protected abstract int getVelocidadDeReparacion();

}
