package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Region;
import algoempires.Terreno;
import algoempires.entidad.Entidad;

public abstract class Edificio extends Entidad {

    private Region regionQueOcupa;
    protected int turnosDeConstruccion;

    public Edificio(Terreno terreno, Casillero casilleroInfIzq) throws CasilleroInvalidoException {
        super(terreno);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
        this.regionQueOcupa = new Region(casilleroInfIzq, getTamanioHorizontal(),getTamanioVertical());
        terrenoDeJuego.ocupar(regionQueOcupa,this);
    }

    protected abstract int getTamanioHorizontal();
    protected abstract int getTamanioVertical();
    protected abstract int getTurnosDeContruccionIniciales();

}
