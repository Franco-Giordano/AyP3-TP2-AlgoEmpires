package algoempires.tablero;

import algoempires.entidad.Entidad;
import algoempires.entidad.unidad.Unidad;
import algoempires.excepciones.PosicionInvalidaException;
import algoempires.excepciones.SoloUnidadesSePuedenDesplazarException;
import algoempires.excepciones.UnidadNoPuedeMoverseException;

public class Casillero {

    private Entidad entidadContenida;
    private Posicion posicion;


    public Casillero(Posicion posicionRecibida) {

        this.posicion = posicionRecibida;
        this.entidadContenida = null;
    }

    public void trasladarUnidadA(Casillero casilleroQueQuieroOcupar) {

        try {

            Unidad unidadQueQuieroTrasladar = (Unidad) this.entidadContenida;

            if (!unidadQueQuieroTrasladar.sePuedeMover()) {
                throw new UnidadNoPuedeMoverseException();
            }

            unidadQueQuieroTrasladar.seMovioA(casilleroQueQuieroOcupar);

            casilleroQueQuieroOcupar.ocupar(unidadQueQuieroTrasladar);

            this.entidadContenida = null;

        } catch (ClassCastException exception) {

            throw new SoloUnidadesSePuedenDesplazarException();

        }


    }

    public void ocupar(Entidad entidadRecibida) {

        if (this.entidadContenida != null) {
            throw new PosicionInvalidaException("El casillero ya se encuentra ocupado");
        }
        this.entidadContenida = entidadRecibida;
    }


    public boolean estaOcupada() {
        return this.entidadContenida != null;
    }

    public Entidad getEntidadContenida() {
        return entidadContenida;
    }

    public boolean contieneA(Entidad entidad) {
        return this.entidadContenida == entidad;
    }

    public void vaciar() {
        this.entidadContenida = null;
    }

    public boolean tieneCoordenadasMayoresA(Posicion maximoBuscado) {
        return this.posicion.esMayorQue(maximoBuscado);
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public boolean tieneCoordenadasMenoresA(Posicion minimoBuscado) {
        return this.posicion.esMenorQue(minimoBuscado);
    }
}
