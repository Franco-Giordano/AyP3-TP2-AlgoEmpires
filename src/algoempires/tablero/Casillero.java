package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.SoloEdificiosPuedenSerReparadosException;
import algoempires.entidad.edificio.Edificio;
import algoempires.entidad.edificio.PlazaCentral;
import algoempires.entidad.unidad.SoloUnidadesSePuedenDesplazarException;
import algoempires.entidad.unidad.Unidad;
import algoempires.entidad.unidad.utilero.Aldeano;

public class Casillero {

    Entidad entidadContenida;
    Posicion posicion;

    public Casillero(Posicion posicionRecibida) {

        this.posicion = posicionRecibida;
        this.entidadContenida = null;
    }


    public void trasladarUnidadA(Casillero casilleroQueQuieroOcupar) {

        try {

            Unidad unidadQueQuieroTrasladar = (Unidad) this.entidadContenida;

            casilleroQueQuieroOcupar.ocupar(unidadQueQuieroTrasladar);

            this.entidadContenida = null;

        } catch (ClassCastException exception) {

            throw new SoloUnidadesSePuedenDesplazarException();

        }


    }

    public void ocupar(Entidad entidadRecibida) {

        if (this.entidadContenida != null) {
            throw new CasilleroInvalidoException();
        }
        this.entidadContenida = entidadRecibida;
    }

    public boolean tieneEstaVida(int vidaAComparar) {
        return this.entidadContenida.tieneEstaVida(vidaAComparar);
    }


    public void reparar() {

        try {
            Edificio edificioAReparar = (Edificio) this.entidadContenida;

            edificioAReparar.reparar();
        } catch (ClassCastException exception) {
            throw new SoloEdificiosPuedenSerReparadosException();
        }
    }

    public boolean estaOcupada() {
        return this.entidadContenida != null;
    }

    public Aldeano crearAldeano(){
        PlazaCentral plazaCentral= (PlazaCentral) this.entidadContenida;
        Aldeano aldeano= plazaCentral.crearAldeano();

        return aldeano;

    }


}
