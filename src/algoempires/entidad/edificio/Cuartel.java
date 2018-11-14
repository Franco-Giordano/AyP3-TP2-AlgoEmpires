package algoempires.entidad.edificio;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;

public class Cuartel extends Edificio {

    final int TAMANIO_HORIZONTAL = 2;
    final int TAMANIO_VERTICAL = 2;
    final int COSTO = 50;
    final int VIDA= 250;
    final int TURNOS_DE_CONSTRUCCION= 3;

    public Cuartel(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {
        super(terreno,casillero);
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

