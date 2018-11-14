package algoempires.entidad.unidad.utilero;

import algoempires.Casillero;
import algoempires.Terreno;
import algoempires.entidad.edificio.Cuartel;
import algoempires.entidad.edificio.PlazaCentral;

public class Aldeano extends Utilero {

    final int VIDA = 50;
    final int COSTO = 25;

    public Aldeano(Terreno terreno, Casillero casillero) {

        super(terreno, casillero);
    }

    public void construirPlazaCentral(Casillero casillero) {

        new PlazaCentral(terrenoDeJuego, casillero);

    }

    public void construirCuartel(Casillero casillero) {

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
