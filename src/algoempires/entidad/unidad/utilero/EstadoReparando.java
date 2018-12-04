package algoempires.entidad.unidad.utilero;

import algoempires.entidad.edificio.Edificio;
import algoempires.excepciones.AldeanoOcupadoException;

public class EstadoReparando extends EstadoAldeano {

    private Edificio edificioSiendoReparado;

    public EstadoReparando(Aldeano aldeano, Edificio edificioSiendoReparado) {
        super(aldeano);
        this.edificioSiendoReparado = edificioSiendoReparado;
    }

    @Override
    protected EstadoAldeano actualizarEntreTurnos() {

        this.edificioSiendoReparado.reparar();

        if (!this.edificioSiendoReparado.tieneVidaLlena()) {
            return this;
        } else {
            return new EstadoRecolectandoOro(aldeano);
        }
    }

    @Override
    public boolean sePuedeMover() {
        return false;
    }

    @Override
    public void chequearQueAldeanoEsteDisponible() {
        throw new AldeanoOcupadoException("El aldeano se encuentra construyendo o reparando un edificio.");
    }
}


