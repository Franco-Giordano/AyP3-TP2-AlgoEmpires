package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;

public class PlazaCentral extends Edificio {

    final int TAMANIO_HORIZONTAL = 2;
    final int TAMANIO_VERTICAL = 2;
    final int COSTO = 100;
    final int VIDA= 450;
    final int TURNOS_DE_CONSTRUCCION= 3;

    public PlazaCentral(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno,casillero);
        this.vida = getVidaInicial();
        this.turnosDeConstruccion = getTurnosDeContruccionIniciales();
    }

    @Override
    protected int getTamanioHorizontal(){
        return TAMANIO_HORIZONTAL;
    }

    @Override
    protected int getTamanioVertical(){
        return TAMANIO_VERTICAL;
    }

    @Override
    protected int getVidaInicial(){
        return VIDA;
    }

    @Override
    protected int getTurnosDeContruccionIniciales(){
        return TURNOS_DE_CONSTRUCCION;
    }

    @Override
    protected int getCosto(){
        return COSTO;
    }



}

