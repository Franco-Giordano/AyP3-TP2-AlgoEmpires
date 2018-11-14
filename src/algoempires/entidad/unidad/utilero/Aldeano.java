package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.CasilleroInvalidoException;
import algoempires.Terreno;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;

public class Aldeano extends Utilero {

    private final int VIDA = 50;
    private final int COSTO = 25;

    public Aldeano(Terreno terreno, Casillero casillero) throws CasilleroInvalidoException {

        super(terreno, casillero);
    }

    public void construirPlazaCentral(Casillero casillero) throws CasilleroInvalidoException {

        new PlazaCentral(terrenoDeJuego, casillero);

    }

    public void construirCuartel(Casillero casillero) throws CasilleroInvalidoException {

        new Cuartel(terrenoDeJuego, casillero);

    }

    public void reparar(Casillero casillero) {

        terrenoDeJuego.reparar(casillero);

    }

    @Override
    protected int getVidaInicial() {
        return VIDA;
    }

    @Override
    protected int getCosto() {

        return COSTO;
    }
}
