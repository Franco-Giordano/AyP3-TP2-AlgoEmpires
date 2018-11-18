package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.Unidad;

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


}
