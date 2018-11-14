package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.Region;
import algoempires.Terreno;
import algoempires.entidad.Entidad;

public abstract class Edificio extends Entidad {

    protected int turnosDeConstruccion;
    private Region regionQueOcupa;

    public Edificio(Terreno terreno, Casillero casilleroInfIzq) {
        super(terreno);
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
